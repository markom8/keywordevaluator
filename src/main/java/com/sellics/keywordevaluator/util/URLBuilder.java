package com.sellics.keywordevaluator.util;

public class URLBuilder {

    private String keyword;

    public URLBuilder setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public String buildURL(){
        return "https://completion.amazon.com/api/2017/suggestions?mid=ATVPDKIKX0DER&alias=aps&prefix=" + keyword + "&event=onKeyPress&limit=10&fb=1&suggestion-type=KEYWORD&suggestion-type=WIDGET";
    }

}
