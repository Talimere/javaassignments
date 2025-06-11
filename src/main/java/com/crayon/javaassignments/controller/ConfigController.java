package com.crayon.javaassignments.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.description}")
    private String appDescription;

    @Value("${app.author}")
    private String appAuthor;

    @GetMapping("/name")
    public ResponseEntity<String> name() {
        return ResponseEntity.ok(appName);
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.ok(appVersion);
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, String>> info() {
        return ResponseEntity.ok(
                getCustomMapOfAppInfo()
        );
    }

    private Map<String, String> getCustomMapOfAppInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("app-name", appName);
        map.put("app-version", appVersion);
        map.put("app-description", appDescription);
        map.put("app-author", appAuthor);
        return map;
    }
}
