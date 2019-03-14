package com.sellics.keywordevaluator.service;


import com.sellics.keywordevaluator.domain.dto.AmazonCompletionDTO;
import com.sellics.keywordevaluator.task.Task;
import com.sellics.keywordevaluator.util.URLBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
public class AmazonCompleationServiceImpl implements AmazonCompleationService {

    private RestTemplate restTemplate;
    private ExecutorService executor = Executors.newFixedThreadPool(10);

    public AmazonCompleationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<AmazonCompletionDTO> getCompleationsForKeyword(String keyword){

        List<Task> tasks = new ArrayList<>();
        for (int i = 1; i <= keyword.length(); i++) {
            tasks.add(new Task(new URLBuilder().setKeyword(keyword.substring(0, i)).buildURL(), restTemplate));
        }
        List<Future<AmazonCompletionDTO>> completionResponses = tasks.stream().map(t->{
            return executor.submit(t);
        }).collect(Collectors.toList());

        List<AmazonCompletionDTO> responses =  completionResponses.stream().map(r -> {
            try {
                return r.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            } catch (ExecutionException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());

        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.yield();
        }

        return responses;
    }


}
