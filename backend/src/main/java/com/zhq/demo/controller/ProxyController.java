package com.zhq.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/proxy")
public class ProxyController {
    @GetMapping("/posts")
    public ResponseEntity<String> getPosts() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts",
                String.class);
        return ResponseEntity.ok(result);
    }
}
