package com.sapient.newfilter.service;

import com.sapient.newfilter.NewsFilterPojo;

public interface IServiceFilter {
    NewsFilterPojo getRelevantNews(String country, String category, String keyword);
}
