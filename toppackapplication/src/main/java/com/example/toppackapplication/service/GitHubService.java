package com.example.toppackapplication.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class GitHubService {
    @Value("${github.api.url}")
    private String apiUrl;
    private final RestTemplate restTemplate;
    public GitHubService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public List<Repository> searchRepository(String keyword){
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .path("/serach/repositories")
                .queryParam("q",keyword)
                .build()
                .toUriString();
        Repository[] repositories = restTemplate.getForObject(url,Repository[].class);
        return Arrays.asList(repositories);
    }
}
