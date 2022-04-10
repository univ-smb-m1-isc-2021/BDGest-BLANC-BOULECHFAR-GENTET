package com.example.bdgesttest.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContributorRepository extends JpaRepository<Contributor, Long> {
    Contributor findContributorById(Long id);
}
