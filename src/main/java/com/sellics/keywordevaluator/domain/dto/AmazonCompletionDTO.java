package com.sellics.keywordevaluator.domain.dto;



import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class AmazonCompletionDTO {

    private String alias;
    private String prefix;
    private String suffix;
    private List<Suggestion> suggestions;
    private String responseId;
    private boolean shuffled;

    public AmazonCompletionDTO() {
    }

    public AmazonCompletionDTO(String alias, String prefix, String suffix, List<Suggestion> suggestions, String responseId, boolean shuffled) {
        this.alias = alias;
        this.prefix = prefix;
        this.suffix = suffix;
        this.suggestions = suggestions;
        this.responseId = responseId;
        this.shuffled = shuffled;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public boolean isShuffled() {
        return shuffled;
    }

    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("alias", alias)
                .append("prefix", prefix)
                .append("suffix", suffix)
                .append("suggestions", suggestions)
                .append("responseId", responseId)
                .append("shuffled", shuffled)
                .toString();
    }
}
