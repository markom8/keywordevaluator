package com.sellics.keywordevaluator.service;

import com.sellics.keywordevaluator.domain.dto.EstimatedKeywordDTO;

import java.util.concurrent.ExecutionException;

/**
 * The interface Amazon estimation service.
 */
public interface AmazonEstimationService {

    /**
     * Estimate keyword.
     *
     * @param keyword the keyword
     * @return the estimated keyword dto
     * @throws ExecutionException the execution exception
     * @throws InterruptedException the interrupted exception
     */
    EstimatedKeywordDTO estimateKeyword(String keyword) throws ExecutionException, InterruptedException;
}
