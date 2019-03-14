package com.sellics.keywordevaluator.domain.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * The type Suggestion.
 */
public class Suggestion
{

    private String suggType;
    private String type;
    private String value;
    private String refTag;
    private boolean ghost;
    private boolean help;
    private List<UnderstandingFeaturesDTO> queryUnderstandingFeatures;
    private boolean xcatOnly;
    private boolean fallback;
    private boolean blackListed;
    private boolean spellCorrected;


    public Suggestion()
    {
    }


    public Suggestion(
        String suggType, String type, String value, String refTag, boolean ghost, boolean help, List<UnderstandingFeaturesDTO> queryUnderstandingFeatures, boolean xcatOnly,
        boolean fallback, boolean blackListed, boolean spellCorrected)
    {
        this.suggType = suggType;
        this.type = type;
        this.value = value;
        this.refTag = refTag;
        this.ghost = ghost;
        this.help = help;
        this.queryUnderstandingFeatures = queryUnderstandingFeatures;
        this.xcatOnly = xcatOnly;
        this.fallback = fallback;
        this.blackListed = blackListed;
        this.spellCorrected = spellCorrected;
    }


    public String getSuggType()
    {
        return suggType;
    }


    public void setSuggType(String suggType)
    {
        this.suggType = suggType;
    }


    public String getType()
    {
        return type;
    }


    public void setType(String type)
    {
        this.type = type;
    }


    public String getValue()
    {
        return value;
    }


    public void setValue(String value)
    {
        this.value = value;
    }


    public String getRefTag()
    {
        return refTag;
    }


    public void setRefTag(String refTag)
    {
        this.refTag = refTag;
    }


    public boolean isGhost()
    {
        return ghost;
    }


    public void setGhost(boolean ghost)
    {
        this.ghost = ghost;
    }


    public boolean isHelp()
    {
        return help;
    }


    public void setHelp(boolean help)
    {
        this.help = help;
    }


    public List<UnderstandingFeaturesDTO> getQueryUnderstandingFeatures()
    {
        return queryUnderstandingFeatures;
    }


    public void setQueryUnderstandingFeatures(List<UnderstandingFeaturesDTO> queryUnderstandingFeatures)
    {
        this.queryUnderstandingFeatures = queryUnderstandingFeatures;
    }


    public boolean isXcatOnly()
    {
        return xcatOnly;
    }


    public void setXcatOnly(boolean xcatOnly)
    {
        this.xcatOnly = xcatOnly;
    }


    public boolean isFallback()
    {
        return fallback;
    }


    public void setFallback(boolean fallback)
    {
        this.fallback = fallback;
    }


    public boolean isBlackListed()
    {
        return blackListed;
    }


    public void setBlackListed(boolean blackListed)
    {
        this.blackListed = blackListed;
    }


    public boolean isSpellCorrected()
    {
        return spellCorrected;
    }


    public void setSpellCorrected(boolean spellCorrected)
    {
        this.spellCorrected = spellCorrected;
    }


    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
            .append("suggType", suggType)
            .append("type", type)
            .append("value", value)
            .append("refTag", refTag)
            .append("ghost", ghost)
            .append("help", help)
            .append("queryUnderstandingFeatures", queryUnderstandingFeatures)
            .append("xcatOnly", xcatOnly)
            .append("fallback", fallback)
            .append("blackListed", blackListed)
            .append("spellCorrected", spellCorrected)
            .toString();
    }
}
