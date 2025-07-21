package com.eazybytes.accounts.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/version")
@Profile({"dev", "test", "staging", "prod"})
public class VersionController {

    @Value("${git.commit.id.abbrev:unknown}")
    private String commitId;

    @Value("${git.branch:unknown}")
    private String branch;

    @Value("${app.version:unknown}")
    private String version;

    @Value("${spring.profiles.active:unknown}")
    private String profile;

    @GetMapping
    public Map<String, String> getVersion() {
        String resolvedVersion = switch (profile) {
            case "dev", "test" -> commitId;
            case "staging", "prod" -> version;
            default -> "unknown";
        };

        return Map.of(
                "environment", profile,
                "version", resolvedVersion,
                "branch", branch
        );
    }
}

