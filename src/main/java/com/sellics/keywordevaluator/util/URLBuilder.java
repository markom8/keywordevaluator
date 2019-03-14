package com.sellics.keywordevaluator.util;

/**
 * The type Url builder.
 */
public class URLBuilder {

    private String keyword;

    public URLBuilder setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }


    /**
     * Build url string.
     *
     * @return the string
     */
    public String buildURL(){
        return "https://completion.amazon.com/api/2017/suggestions?mid=ATVPDKIKX0DER&alias=aps&prefix=" + keyword + "&event=onKeyPress&limit=10&fb=1&suggestion-type=KEYWORD&suggestion-type=WIDGET";
    }

}
