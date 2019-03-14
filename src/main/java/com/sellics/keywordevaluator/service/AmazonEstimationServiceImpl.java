package com.sellics.keywordevaluator.service;

import com.sellics.keywordevaluator.domain.dto.AmazonCompletionDTO;
import com.sellics.keywordevaluator.domain.dto.EstimatedKeywordDTO;
import com.sellics.keywordevaluator.domain.dto.Suggestion;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class AmazonEstimationServiceImpl implements AmazonEstimationService {

    private AmazonCompleationService amazonCompleationService;

    public AmazonEstimationServiceImpl(AmazonCompleationService amazonCompleationService)
    {
        this.amazonCompleationService = amazonCompleationService;
    }

    @Override
    public EstimatedKeywordDTO estimateKeyword(String keyword) throws ExecutionException, InterruptedException
    {
        List<AmazonCompletionDTO> completionResponses = amazonCompleationService.getCompleationsForKeyword(keyword);
        List<List<Suggestion>> suggestionLists = completionResponses.stream().map(AmazonCompletionDTO::getSuggestions).collect(Collectors.toList());
        Set<String> suggestionKeywords = new HashSet<>();
        for (List<Suggestion> suggestionList:suggestionLists)
        {
            for (Suggestion suggestion:suggestionList)
            {
                suggestionKeywords.add(suggestion.getValue());
            }
        }
        return null;
    }


}
