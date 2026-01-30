package com.votingsystem.model;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;
    @Setter
    private String party;

    @Setter
    @ManyToOne
    @JoinColumn(name = "election_id", nullable = false)
    private Election election;

    // ✅ REQUIRED getters & setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getParty() {
        return party;
    }

    public Election getElection() {
        return election;
    }

}
