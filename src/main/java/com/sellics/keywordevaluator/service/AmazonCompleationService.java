package com.sellics.keywordevaluator.service;

import com.sellics.keywordevaluator.domain.dto.AmazonCompletionDTO;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface AmazonCompleationService {
    List<AmazonCompletionDTO> getCompleationsForKeyword(String keyword) throws InterruptedException, ExecutionException;
}
