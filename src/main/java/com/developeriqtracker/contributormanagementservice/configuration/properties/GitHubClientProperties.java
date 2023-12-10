package com.developeriqtracker.contributormanagementservice.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("git-hub")
public class GitHubClientProperties {

    private String contributorDetailUrl;
}
