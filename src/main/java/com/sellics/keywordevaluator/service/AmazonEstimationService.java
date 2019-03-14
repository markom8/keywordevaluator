package com.sellics.keywordevaluator.service;

import com.sellics.keywordevaluator.domain.dto.EstimatedKeywordDTO;

import java.util.concurrent.ExecutionException;

public interface AmazonEstimationService {

    EstimatedKeywordDTO estimateKeyword(String keyword) throws ExecutionException, InterruptedException;
}
