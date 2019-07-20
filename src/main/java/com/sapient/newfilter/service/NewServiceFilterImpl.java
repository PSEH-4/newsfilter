package com.sapient.newfilter.service;

import com.sapient.newfilter.NewsFilterPojo;
import com.sapient.newfilter.news.Article;
import com.sapient.newfilter.news.News;
import com.sapient.newfilter.service.IServiceFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NewServiceFilterImpl implements IServiceFilter {

    private final String newAPIURl = "https://newsapi.org/v2/top-headlines?country={countryName}&category={categoryValue}&apiKey=ccaf5d41cc5140c984818c344edcc14d";

    @Override
    public NewsFilterPojo getRelevantNews(String country, String category, String keyword) {

        String endPoint = newAPIURl.replace("{countryName}", country);
        endPoint = endPoint.replace("{categoryValue}", category);
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject(endPoint, News.class);

        NewsFilterPojo pojo = new NewsFilterPojo();
        pojo.setCountry(country);
        pojo.setCategory(category);
        pojo.setKeyword(keyword);
        for (Article article : news.getArticles()) {

            StringBuilder resultbuilder = new StringBuilder();
            resultbuilder.append(article.getAuthor() == null ? "" : article.getAuthor());
            resultbuilder.append(article.getTitle() == null ? "" : article.getTitle());
            resultbuilder.append(article.getDescription() == null ? "" : article.getDescription());
            resultbuilder.append(article.getContent() == null ? "" : article.getContent());

            //Pattern pattern = Pattern.compile(resultbuilder.toString(),Pattern.CASE_INSENSITIVE);
            //Matcher matcher = pattern.matcher(keyword);
            if(resultbuilder.toString().toLowerCase().contains(keyword)) {
                if(article.getTitle() != null) {
                    if (pojo.getTitles() != null) {
                        pojo.getTitles().add(article.getTitle());
                    } else {
                        pojo.setTitles(new ArrayList<>());
                        pojo.getTitles().add(article.getTitle());
                    }
                }

                if(article.getDescription() != null) {
                    if (pojo.getDescriptions() != null) {
                        pojo.getDescriptions().add(article.getDescription());
                    } else {
                        pojo.setDescriptions(new ArrayList<>());
                        pojo.getDescriptions().add(article.getDescription());
                    }
                }


                if(pojo.getUrls() != null) {
                    pojo.getUrls().add(article.getDescription());
                } else {
                    pojo.setUrls(new ArrayList<String>());
                    pojo.getUrls().add(article.getDescription());
                }
            }

        }
        return pojo;
    }
}
