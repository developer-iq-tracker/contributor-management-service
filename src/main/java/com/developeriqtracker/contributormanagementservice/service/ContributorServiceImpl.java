package com.developeriqtracker.contributormanagementservice.service;

import com.developeriqtracker.contributormanagementservice.dto.ContributorDto;
import com.developeriqtracker.contributormanagementservice.model.Contributor;
import com.developeriqtracker.contributormanagementservice.repository.ContributorRepository;
import com.developeriqtracker.contributormanagementservice.service.external.GithubExternalClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ContributorServiceImpl implements ContributorService {

    private final GithubExternalClientService githubExternalClientService;
    private final ContributorRepository contributorRepository;

    @Override
    public List<Contributor> syncContributorDetailsFromGithub() {
        List<Contributor> contributors = new ArrayList<>();
        log.info("sync Contributor Details From Github | process Started");
        List<ContributorDto> contributorDtoList = this.githubExternalClientService.getContributorDetails();

        contributorDtoList.forEach(contributorDto -> {
            Contributor contributor = this.generateGitHubUserObject(contributorDto);
            log.info("sync Contributor Details From Github | save new record | {}", contributor);
            this.checkAndRemoveOldRecords(contributor);
            contributors.add(contributor);
        });

        this.contributorRepository.saveAll(contributors);
        log.info("sync Contributor Details From Github | process end");
        return contributors;

    }

    @Override
    public List<Contributor> getAllContributors() {
        return this.contributorRepository.findAll();
    }

    private void checkAndRemoveOldRecords(Contributor contributor) {
        Optional<Contributor> oldContributor = this.contributorRepository.findByGitHubId(contributor.getGitHubId());
        oldContributor.ifPresent(this.contributorRepository::delete);
    }

    private Contributor generateGitHubUserObject(ContributorDto contributorDto) {
        return Contributor.builder()
                .gitHubId(contributorDto.getId())
                .login(contributorDto.getLogin())
                .contributions(contributorDto.getContributions())
                .type(contributorDto.getType())
                .siteAdmin(contributorDto.isSiteAdmin())
                .reposUrl(contributorDto.getReposUrl())
                .build();
    }
}
