package com.sellics.keywordevaluator.domain.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class UnderstandingFeaturesDTO {

    String source;
    List<String> annotations;

    public UnderstandingFeaturesDTO() {
    }

    public UnderstandingFeaturesDTO(String source, List<String> annotations) {
        this.source = source;
        this.annotations = annotations;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<String> annotations) {
        this.annotations = annotations;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("source", source)
                .append("annotations", annotations)
                .toString();
    }
}
