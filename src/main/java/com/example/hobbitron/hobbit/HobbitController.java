package com.example.hobbitron.hobbit;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HobbitController {

    private HobbitService hobbitService;

    public HobbitController(HobbitService hobbitService) {
        this.hobbitService = hobbitService;
    }
}
