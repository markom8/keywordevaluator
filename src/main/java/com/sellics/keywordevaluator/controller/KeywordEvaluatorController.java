package com.sellics.keywordevaluator.controller;

import com.sellics.keywordevaluator.domain.dto.EstimatedKeywordDTO;
import com.sellics.keywordevaluator.service.AmazonEstimationService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(path = "evaluate")
public class KeywordEvaluatorController
{
    private AmazonEstimationService amazonEstimationService;

    public KeywordEvaluatorController(AmazonEstimationService amazonEstimationService)
    {
        this.amazonEstimationService = amazonEstimationService;
    }

    @GetMapping()
    public EstimatedKeywordDTO evaluateKeyword(@RequestParam String keyword) throws ExecutionException, InterruptedException
    {

        return amazonEstimationService.estimateKeyword(keyword);
    }
}
