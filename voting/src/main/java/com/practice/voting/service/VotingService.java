package com.practice.voting.service;

import com.practice.voting.dto.CandidateRequest;
import com.practice.voting.dto.VoteRequest;
import com.practice.voting.entity.CandidateEntity;

import java.util.List;
import java.util.Optional;

public interface VotingService {

    String addCandidate(CandidateRequest candidateRequest);

    List<CandidateEntity> getCandidate();

    String voteCandidate(VoteRequest voteRequest);

    Optional<CandidateEntity> getFrontRunner();
}
