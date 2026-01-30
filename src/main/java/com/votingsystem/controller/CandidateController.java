package com.votingsystem.controller;

import com.votingsystem.model.Candidate;
import com.votingsystem.model.Election;
import com.votingsystem.repository.CandidateRepository;
import com.votingsystem.repository.ElectionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class CandidateController {

    private final CandidateRepository candidateRepository;
    private final ElectionRepository electionRepository;

    public CandidateController(
            CandidateRepository candidateRepository,
            ElectionRepository electionRepository
    ) {
        this.candidateRepository = candidateRepository;
        this.electionRepository = electionRepository;
    }

    @PostMapping("/candidate")
    public ResponseEntity<?> addCandidate(@RequestBody Candidate candidate) {

        Election election = electionRepository
                .findById(candidate.getElection().getId())
                .orElseThrow(() -> new RuntimeException("Election not found"));

        candidate.setElection(election);
        candidateRepository.save(candidate);

        return ResponseEntity.ok("Candidate added successfully");
    }
}
