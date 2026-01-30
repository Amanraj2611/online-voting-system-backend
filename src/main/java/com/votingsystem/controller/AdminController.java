package com.votingsystem.controller;

import com.votingsystem.repository.VoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final VoteRepository voteRepository;

    public AdminController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @GetMapping("/results/{electionId}")
    public List<Map<String, Object>> getResults(@PathVariable Long electionId) {

        List<Object[]> data = voteRepository.getResultByElection(electionId);

        return data.stream().map(row -> {
            Map<String, Object> map = new HashMap<>();
            map.put("candidate", row[0]);
            map.put("votes", row[1]);
            return map;
        }).toList();
    }
}
