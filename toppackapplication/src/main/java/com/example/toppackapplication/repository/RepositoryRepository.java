package com.example.toppackapplication.repository;

import com.example.toppackapplication.entity.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@org.springframework.stereotype.Repository

public interface RepositoryRepository extends JpaRepository<Repository,Long> {
    @Query(value = "SELECT r.name FROM Repository r GROUP BY r.name ORDER BY COUNT(r.name) DESC")
    List<String> findTop10Packages();
}
