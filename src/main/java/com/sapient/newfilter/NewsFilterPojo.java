package com.sapient.newfilter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewsFilterPojo {

    private String Country;

    private String Category;

    private String keyword;

    private List<String> titles;

    private List<String> descriptions;

    private List<String> urls;



}
