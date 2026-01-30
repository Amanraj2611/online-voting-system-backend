package com.votingsystem.controller;

import com.votingsystem.model.Election;
import com.votingsystem.repository.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/election")
public class ElectionController {

    @Autowired
    private ElectionRepository electionRepository;

    @GetMapping
    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }
}
