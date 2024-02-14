package com.example.toppackapplication.controller;

import com.example.toppackapplication.service.GitHubService;
import com.example.toppackapplication.service.RepoitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repositories")
public class RepositoryController {
    @Autowired
    private RepoitoryService repoitoryService;
    @Autowired
    private GitHubService gitHubService;
    @GetMapping("/search")
    public ResponseEntity<List<Repository>> searchRepositories(@RequestParam String keyword){
        List<org.springframework.stereotype.Repository> repositories = gitHubService.searchRepository(keyword);
        return ResponseEntity.ok(repositories);
    }

    @PostMapping("/import")
    public ResponseEntity<String> importRepository(@RequestBody String packageJson){
        repoitoryService.importRepositories(packageJson);
        return ResponseEntity.ok("Repositories imported successfully");
    }

    @GetMapping("/top-packages")
    public ResponseEntity<List<String>> getTopPackage(){
        List<String> topPackages = repoitoryService.calculateTopPackages();
        return ResponseEntity.ok(topPackages);
    }
}
