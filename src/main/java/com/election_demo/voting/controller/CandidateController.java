package com.election_demo.voting.controller;

import com.election_demo.voting.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CandidateController {

    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    // Endpoint to add a new candidate
    @GetMapping("/entercandidate")
    public String enterCandidate(@RequestParam String name) {
        return candidateService.addCandidate(name);
    }

    // Endpoint to cast a vote for a candidate
    @GetMapping("/castvote")
    public String castVote(@RequestParam String name) {
        return candidateService.castVote(name);
    }

    // Endpoint to get the vote count of a specific candidate
    @GetMapping("/countvote")
    public String countVote(@RequestParam String name) {
        Optional<Integer> voteCount = candidateService.getVoteCount(name);
        return voteCount.map(count -> "Vote count for " + name + " is: " + count)
                .orElse("Candidate not found!");
    }

    // Endpoint to list all candidates with their vote counts
    @GetMapping("/listvote")
    public Map<String, Integer> listVote() {
        return candidateService.listAllCandidates();
    }

    // Endpoint to get the candidate with the highest vote count
    @GetMapping("/getwinner")
    public String getWinner() {
        return candidateService.listAllCandidates().entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> "Winner is: " + entry.getKey() + " with " + entry.getValue() + " votes.")
                .orElse("No candidates available!");
    }
//    First commit done!
}
