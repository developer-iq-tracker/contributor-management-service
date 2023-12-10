package com.developeriqtracker.contributormanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContributorDto {

    @JsonProperty("login")
    private String login;

    @JsonProperty("id")
    private int id;

    @JsonProperty("repos_url")
    private String reposUrl;

    @JsonProperty("type")
    private String type;

    @JsonProperty("site_admin")
    private boolean siteAdmin;

    @JsonProperty("contributions")
    private int contributions;

}
