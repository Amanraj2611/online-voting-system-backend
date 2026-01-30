package com.votingsystem.repository;

import com.votingsystem.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    boolean existsByVoterIdAndElectionId(Long voterId, Long electionId);

    @Query("""
        SELECT c.name, COUNT(v.id)
        FROM Vote v
        JOIN v.candidate c
        WHERE v.election.id = :electionId
        GROUP BY c.name
    """)
    List<Object[]> getResultByElection(@Param("electionId") Long electionId);
}
