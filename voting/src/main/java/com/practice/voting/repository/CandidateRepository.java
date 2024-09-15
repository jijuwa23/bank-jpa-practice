package com.practice.voting.repository;

import com.practice.voting.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity,Long> {

    CandidateEntity findByCandidateName(String name);

    Optional<CandidateEntity> findTopPointsByOrderByPointsDesc();
}
