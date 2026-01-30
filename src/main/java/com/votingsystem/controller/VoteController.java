package com.votingsystem.controller;

import com.votingsystem.model.Candidate;
import com.votingsystem.model.User;
import com.votingsystem.model.Vote;
import com.votingsystem.repository.CandidateRepository;
import com.votingsystem.repository.UserRepository;
import com.votingsystem.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vote")
@CrossOrigin(origins = "http://localhost:3000")
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String vote(@RequestParam Long candidateId,
                       Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Long electionId = candidate.getElection().getId();

        // ✅ Prevent double voting
        if (voteRepository.existsByVoterIdAndElectionId(user.getId(), electionId)) {
            return "You have already voted in this election";
        }

        Vote vote = new Vote();
        vote.setVoter(user);
        vote.setCandidate(candidate);
        vote.setElection(candidate.getElection());

        voteRepository.save(vote);

        return "Vote submitted successfully";
    }
}