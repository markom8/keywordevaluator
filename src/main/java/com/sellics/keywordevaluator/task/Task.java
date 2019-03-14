package com.sellics.keywordevaluator.task;

import com.sellics.keywordevaluator.domain.dto.AmazonCompletionDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;

/**
 * The type Task.
 */
public class Task implements Callable<AmazonCompletionDTO>
{

    private String url;
    private RestTemplate restTemplate;


    public Task(String url, RestTemplate restTemplate)
    {
        this.url = url;
        this.restTemplate = restTemplate;
    }


    @Override
    public AmazonCompletionDTO call()
    {
        ResponseEntity<AmazonCompletionDTO> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<AmazonCompletionDTO>()
            {
            });
        return response.getBody();
    }
}
