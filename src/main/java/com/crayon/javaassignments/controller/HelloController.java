package com.crayon.javaassignments.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> helloName(@PathVariable String name) {
        return ResponseEntity.ok("Hello " +  name);
    }

    @GetMapping("/time")
    public ResponseEntity<Long> time() {
        return ResponseEntity.ok(Instant.now().getEpochSecond());
    }
}
