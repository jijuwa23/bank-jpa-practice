package com.practice.voting.controller;

import com.practice.voting.dto.CandidateRequest;
import com.practice.voting.dto.VoteRequest;
import com.practice.voting.entity.CandidateEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface VotingAPI {

ResponseEntity<String> addCandidate(CandidateRequest candidateRequest);

List<CandidateEntity> getCandidate();

ResponseEntity<String> voteCandidate(VoteRequest voteRequest);

Optional<CandidateEntity> getFrontRunner();
}
