package com.crayon.javaassignments.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

package com.yourdomain.springdemo.controller;

import com.yourdomain.springdemo.dto.AppInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConfigController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.description}")
    private String appDescription;

    @Value("${app.author}")
    private String appAuthor;

     @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello, Spring!");
    }

      @GetMapping("/calc/add")
    public ResponseEntity<Integer> add(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok(a + b);
    }

    @GetMapping("/calc/subtract")
    public ResponseEntity<Integer> subtract(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok(a - b);
    }

    @GetMapping("/calc/multiply")
    public ResponseEntity<Integer> multiply(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok(a * b);
    }

    @GetMapping("/calc/divide")
    public ResponseEntity<Double> divide(@RequestParam int a, @RequestParam int b) {
        if (b == 0) {
            return ResponseEntity.badRequest().body(Double.NaN);
        }
        return ResponseEntity.ok((double) a / b);
    }

    @GetMapping("/config/app-name")
    public ResponseEntity<String> getAppName() {
        return ResponseEntity.ok(appName);
    }

    @GetMapping("/config/version")
    public ResponseEntity<String> getAppVersion() {
        return ResponseEntity.ok(appVersion);
    }

    @GetMapping("/config/info")
    public ResponseEntity<AppInfo> getAppInfo() {
        return ResponseEntity.ok(new AppInfo(appName, appVersion, appDescription, appAuthor));
    }
}


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
