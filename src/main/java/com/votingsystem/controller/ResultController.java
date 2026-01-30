package com.votingsystem.controller;

import com.votingsystem.repository.VoteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/result")
public class ResultController {

    private final VoteRepository voteRepository;

    public ResultController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @GetMapping("/{electionId}")
    public List<Map<String, Object>> getResult(@PathVariable Long electionId) {

        List<Object[]> data = voteRepository.getResultByElection(electionId);

        return data.stream().map(row -> {
            Map<String, Object> map = new HashMap<>();
            map.put("candidate", row[0]);
            map.put("votes", row[1]);
            return map;
        }).toList();
    }
}

