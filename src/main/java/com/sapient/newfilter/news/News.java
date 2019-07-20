package com.sapient.newfilter.news;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class News {
    @JsonProperty("status")
    private String status;
    @JsonProperty("totalResults")
    private Integer totalResults;
    @JsonProperty("articles")
    private List<Article> articles = null;

    private String str;
}
