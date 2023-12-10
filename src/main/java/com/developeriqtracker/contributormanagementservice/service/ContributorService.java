package com.developeriqtracker.contributormanagementservice.service;


import com.developeriqtracker.contributormanagementservice.model.Contributor;

import java.util.List;

public interface ContributorService {

    List<Contributor> syncContributorDetailsFromGithub();

    List<Contributor> getAllContributors();
}
