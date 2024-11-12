package com.election_demo.voting.service;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CandidateService {
    private final Map<String, AtomicInteger> candidates = new ConcurrentHashMap<>();

    // Add a new candidate with vote count initialized to 0
    public String addCandidate(String name) {
        if (candidates.containsKey(name)) {
            return "Candidate already exists!";
        }
        candidates.put(name, new AtomicInteger(0));
        return "Candidate added successfully!";
    }

    // Increment the vote count of a candidate
    public String castVote(String name) {
        AtomicInteger voteCount = candidates.get(name);
        if (voteCount != null) {
            voteCount.incrementAndGet();
            return "Vote cast successfully!";
        }
        return "Candidate not found!";
    }

    // Get the vote count of a specific candidate
    public Optional<Integer> getVoteCount(String name) {
        AtomicInteger voteCount = candidates.get(name);
        // Return the integer value of voteCount wrapped in Optional if candidate exists
        return voteCount != null ? Optional.of(voteCount.get()) : Optional.empty();
    }

    // List all candidates and their vote counts
    public Map<String, Integer> listAllCandidates() {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, AtomicInteger> entry : candidates.entrySet()) {
            result.put(entry.getKey(), entry.getValue().get()); // Use get() to retrieve integer value from AtomicInteger
        }
        return result;
    }
}
