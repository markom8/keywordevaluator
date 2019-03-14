package com.sellics.keywordevaluator.controller;

import com.sellics.keywordevaluator.domain.dto.EstimatedKeywordDTO;
import com.sellics.keywordevaluator.service.AmazonEstimationService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * The type Keyword evaluator controller.
 */
@RestController
@RequestMapping(path = "evaluate")
public class KeywordEvaluatorController
{
    private AmazonEstimationService amazonEstimationService;

    public KeywordEvaluatorController(AmazonEstimationService amazonEstimationService)
    {
        this.amazonEstimationService = amazonEstimationService;
    }


    /**
     * Evaluate estimated keyword.
     *
     * @param keyword the keyword
     * @return the estimated keyword dto
     * @throws ExecutionException the execution exception
     * @throws InterruptedException the interrupted exception
     */
    @GetMapping()
    public EstimatedKeywordDTO evaluateKeyword(@RequestParam String keyword) throws ExecutionException, InterruptedException
    {

        return amazonEstimationService.estimateKeyword(keyword);
    }
}
