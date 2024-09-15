package com.practice.voting.service.impl;

import com.practice.voting.dto.CandidateRequest;
import com.practice.voting.dto.VoteRequest;
import com.practice.voting.entity.CandidateEntity;
import com.practice.voting.repository.CandidateRepository;
import com.practice.voting.service.VotingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VotingImpl implements VotingService {

    private final CandidateRepository candidateRepository;

    @Override
    public String addCandidate(CandidateRequest candidateRequest) {

        CandidateEntity candidateEntity = new CandidateEntity();
        candidateEntity.setCandidateName(candidateRequest.getCandidateName());

        candidateRepository.save(candidateEntity);

        return "Candidate added!";
    }

    @Override
    public List<CandidateEntity> getCandidate() {

        return candidateRepository.findAll();
    }

    @Override
    public String voteCandidate(VoteRequest voteRequest) {
        addVote(voteRequest.getFirstVote(),3);
        addVote(voteRequest.getSecondVote(),2);
        addVote(voteRequest.getThirdVote(),1);
        return "Votes added!";
    }

    @Override
    public Optional<CandidateEntity> getFrontRunner() {
        return candidateRepository.findTopPointsByOrderByPointsDesc();
    }

    private void addVote(String candidateName,int points){
        CandidateEntity candidateEntity = candidateRepository.findByCandidateName(candidateName);
        candidateEntity.setPoints(points);

        candidateRepository.save(candidateEntity);
    }
}
