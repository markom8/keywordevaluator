package com.sellics.keywordevaluator.service;

import com.sellics.keywordevaluator.domain.dto.AmazonCompletionDTO;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * The interface Amazon completion service.
 */
public interface AmazonCompleationService {
    /**
     * Gets completions for keyword.
     *
     * @param keyword the keyword
     * @return the completions for keyword
     * @throws InterruptedException the interrupted exception
     * @throws ExecutionException the execution exception
     */
    List<AmazonCompletionDTO> getCompletionsForKeyword(String keyword) throws InterruptedException, ExecutionException;
}
