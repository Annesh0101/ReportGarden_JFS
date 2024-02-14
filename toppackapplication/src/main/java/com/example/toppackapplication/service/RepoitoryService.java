package com.example.toppackapplication.service;

import com.example.toppackapplication.repository.RepositoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepoitoryService {
    @Autowired
    private RepositoryRepository repositoryRepository;
    @Autowired
    private GitHubService gitHubService;

    public void importRepositories(String packageJson){
        Iterable repositories = gitHubService.searchRepository("java");
        repositoryRepository.saveAll(repositories);
    }

    public List<String> calculateTopPackages(){
        return repositoryRepository.findTop10Packages();
    }
}
