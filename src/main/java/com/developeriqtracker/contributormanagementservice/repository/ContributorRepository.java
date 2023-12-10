package com.developeriqtracker.contributormanagementservice.repository;

import com.developeriqtracker.contributormanagementservice.model.Contributor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContributorRepository extends MongoRepository<Contributor, String> {
    Optional<Contributor> findByGitHubId(int gitHubId);
}
