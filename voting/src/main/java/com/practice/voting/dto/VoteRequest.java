package com.practice.voting.dto;

import lombok.Data;

@Data
public class VoteRequest {
    private String firstVote;
    private String secondVote;
    private String thirdVote;
}
