package com.sapient.newfilter.news;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Source {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
}
