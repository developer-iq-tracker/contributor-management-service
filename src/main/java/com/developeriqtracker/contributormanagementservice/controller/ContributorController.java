package com.developeriqtracker.contributormanagementservice.controller;

import com.developeriqtracker.contributormanagementservice.model.Contributor;
import com.developeriqtracker.contributormanagementservice.service.ContributorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contributor")
public class ContributorController {

    private ContributorService contributorService;

    @GetMapping("/sync-from-git-hub")
    public ResponseEntity<List<Contributor>> syncContributorDetailsFromGithub() {
        return ResponseEntity.ok(this.contributorService.syncContributorDetailsFromGithub());
    }

    @GetMapping("/list")
    public ResponseEntity<List<Contributor>> getAllContributors() {
        return ResponseEntity.ok(this.contributorService.getAllContributors());
    }
}
