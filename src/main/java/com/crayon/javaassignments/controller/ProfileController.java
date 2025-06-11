package com.crayon.javaassignments.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProfileController
{


    private final Environment environment;

    @Value("${app.mode:Not Set}")
    private String appMode;

    public ProfileController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/profile")
    public String getActiveProfile() {
        String[] activeProfiles = environment.getActiveProfiles();
        if (activeProfiles.length == 0) {
            return "No active profile (using default)";
        }
        return "Active Profile: " + String.join(", ", activeProfiles);
    }

    @GetMapping("/behavior")
    public String getProfileBehavior() {
        String[] profiles = environment.getActiveProfiles();
        if (profiles.length == 0) {
            return "Default behavior";
        }

        String profile = profiles[0];
        switch (profile) {
            case "dev":
                return "This is development behavior";
            case "prod":
                return "This is production behavior";
            default:
                return "Behavior for profile: " + profile;
        }
    }

    @GetMapping("/mode")
    public String getAppMode() {
        return "Application Mode: " + appMode;
    }
}


