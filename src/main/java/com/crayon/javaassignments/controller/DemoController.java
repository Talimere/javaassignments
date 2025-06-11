package com.crayon.javaassignments.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demo/resource")
public class DemoController {

    private Map<Long, String> inMemoryMap = new HashMap<>();

    @GetMapping("/{id}")
    public ResponseEntity<String> get(@PathVariable Long id) {
        if(!inMemoryMap.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(inMemoryMap.get(id));
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody String text) {
        Long key = inMemoryMap.size() + 1L;
        inMemoryMap.put(key, text);
        return ResponseEntity.created(URI.create("http://localhost:8080/api/demo/resource/" + key)).body(inMemoryMap.get(key));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> put(@PathVariable Long id, @RequestBody String text) {
        if(!inMemoryMap.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        inMemoryMap.put(id, text);
        return ResponseEntity.ok(inMemoryMap.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if(!inMemoryMap.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        inMemoryMap.remove(id);
        return ResponseEntity.noContent().build();
    }

}
