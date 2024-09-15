package com.practice.voting.controller.impl;

import com.practice.voting.controller.VotingAPI;
import com.practice.voting.dto.CandidateRequest;
import com.practice.voting.dto.VoteRequest;
import com.practice.voting.entity.CandidateEntity;
import com.practice.voting.service.VotingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/voting")
public class VotingController implements VotingAPI {

    private final VotingService votingService;

    @PostMapping("/candidate")
    @Override
    public ResponseEntity<String> addCandidate(@RequestBody CandidateRequest candidateRequest) {
       return ResponseEntity.ok(votingService.addCandidate(candidateRequest));
    }

    @GetMapping("/candidates")
    @Override
    public List<CandidateEntity> getCandidate() {
        return votingService.getCandidate();
    }

    @PostMapping("/vote")
    @Override
    public ResponseEntity<String> voteCandidate(@RequestBody VoteRequest voteRequest) {
        return ResponseEntity.ok(votingService.voteCandidate(voteRequest));
    }
    @GetMapping("candidates/frontRunner")
    @Override
    public Optional<CandidateEntity> getFrontRunner() {
        return votingService.getFrontRunner();
    }
}
