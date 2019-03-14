package com.sellics.keywordevaluator.domain.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The type Estimated keyword dto.
 */
public class EstimatedKeywordDTO {
    private String keyword;
    private int score;


    public EstimatedKeywordDTO()
    {
    }


    public EstimatedKeywordDTO(String keyword, int score)
    {
        this.keyword = keyword;
        this.score = score;
    }


    public String getKeyword()
    {
        return keyword;
    }


    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }


    public int getScore()
    {
        return score;
    }


    public void setScore(int score)
    {
        this.score = score;
    }


    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
            .append("keyword", keyword)
            .append("score", score)
            .toString();
    }
}
