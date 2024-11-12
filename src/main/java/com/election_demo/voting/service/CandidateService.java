package com.election_demo.voting.service;

import com.election_demo.voting.model.Candidate;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CandidateService {
    private final Map<String, Candidate> candidates = new HashMap<>();

    // Add a new candidate with vote count initialized to 0
    public String addCandidate(String name) {
        if (candidates.containsKey(name)) {
            return "Candidate already exists!";
        }
        candidates.put(name, new Candidate(name));
        return "Candidate added successfully!";
    }

    // Increment the vote count of a candidate
    public String castVote(String name) {
        Candidate candidate = candidates.get(name);
        if (candidate != null) {
            candidate.incrementVoteCount();
            return "Vote cast successfully!";
        }
        return "Candidate not found!";
    }

    // Get the vote count of a specific candidate
    public Optional<Integer> getVoteCount(String name) {
        Candidate candidate = candidates.get(name);
        return candidate != null ? Optional.of(candidate.getVoteCount()) : Optional.empty();
    }

    // List all candidates and their vote counts
    public Map<String, Integer> listAllCandidates() {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Candidate> entry : candidates.entrySet()) {
            result.put(entry.getKey(), entry.getValue().getVoteCount());
        }
        return result;
    }
}
