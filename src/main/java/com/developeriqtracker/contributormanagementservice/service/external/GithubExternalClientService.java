package com.developeriqtracker.contributormanagementservice.service.external;

import com.developeriqtracker.contributormanagementservice.configuration.properties.GitHubClientProperties;
import com.developeriqtracker.contributormanagementservice.dto.ContributorDto;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@AllArgsConstructor
public class GithubExternalClientService {

    private final RestTemplate restTemplate;
    private final GitHubClientProperties clientProperties;

    public List<ContributorDto> getContributorDetails() {
        ResponseEntity<List<ContributorDto>> response = restTemplate.exchange(clientProperties.getContributorDetailUrl(), HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }


}
