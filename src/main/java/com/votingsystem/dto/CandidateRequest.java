package com.votingsystem.dto;

public class CandidateRequest {

    private String name;
    private String party;
    private Long electionId;

    public String getName() {
        return name;
    }

    public String getParty() {
        return party;
    }

    public Long getElectionId() {
        return electionId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public void setElectionId(Long electionId) {
        this.electionId = electionId;
    }
}
