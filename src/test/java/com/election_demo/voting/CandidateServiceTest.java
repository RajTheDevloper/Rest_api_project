package com.election_demo.voting;

import com.election_demo.voting.service.CandidateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CandidateServiceTest {
    private CandidateService candidateService;

    @BeforeEach
    void setUp() {
        candidateService = new CandidateService();
    }

    @Test
    void testAddCandidate() {
        String result = candidateService.addCandidate("ajay");
        assertEquals("Candidate added successfully!", result);
        assertTrue(candidateService.listAllCandidates().containsKey("ajay"));
    }

    @Test
    void testCastVote() {
        candidateService.addCandidate("ajay");
        String result = candidateService.castVote("ajay");
        assertEquals("Vote cast successfully!", result);
        Optional<Integer> voteCount = candidateService.getVoteCount("ajay");
        assertTrue(voteCount.isPresent());
        assertEquals(1, voteCount.get());
    }

    @Test
    void testCountVote() {
        candidateService.addCandidate("ajay");
        candidateService.castVote("ajay");
        Optional<Integer> voteCount = candidateService.getVoteCount("ajay");
        assertEquals(Optional.of(1), voteCount);
    }

    @Test
    void testListVote() {
        candidateService.addCandidate("ajay");
        candidateService.castVote("ajay");
        Map<String, Integer> candidates = candidateService.listAllCandidates();
        assertEquals(1, candidates.size());
        assertEquals(1, candidates.get("ajay"));
    }

    @Test
    void testGetWinner() {
        candidateService.addCandidate("ajay");
        candidateService.addCandidate("vijay");
        candidateService.castVote("ajay");
        candidateService.castVote("ajay");
        candidateService.castVote("vijay");

        String winner = candidateService.listAllCandidates().entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No candidates available!");

        assertEquals("ajay", winner);
    }
}
