package com.sellics.keywordevaluator.service;

import com.sellics.keywordevaluator.domain.dto.AmazonCompletionDTO;
import com.sellics.keywordevaluator.domain.dto.EstimatedKeywordDTO;
import com.sellics.keywordevaluator.domain.dto.Suggestion;
import org.springframework.stereotype.Service;

import java.util.*;
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
        List<AmazonCompletionDTO> completionResponses = amazonCompleationService.getCompletionsForKeyword(keyword);
        List<List<Suggestion>> suggestionLists = completionResponses.stream().map(AmazonCompletionDTO::getSuggestions).collect(Collectors.toList());
        Map<String, Integer> suggestionKeywords = new HashMap<>();
        for (List<Suggestion> suggestionList : suggestionLists) {
            for (Suggestion suggestion:suggestionList)
            {
                Integer frequency = suggestionKeywords.get(suggestion.getValue());
                suggestionKeywords.put(suggestion.getValue(), (frequency == null) ? 1 : frequency+1);
            }
        }

        int numberOfSuggestions = 0;
        for (Map.Entry<String, Integer> entry : suggestionKeywords.entrySet()){
            if(entry.getKey().contains(keyword)) {
                numberOfSuggestions+=entry.getValue();
            }
        }

        return new EstimatedKeywordDTO(keyword, (numberOfSuggestions*10)/completionResponses.size());
    }
}
