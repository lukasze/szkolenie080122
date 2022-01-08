package com.example.hobbitron.hobbit;

import org.springframework.stereotype.Service;

@Service
public class HobbitService {

    private HobbitRepository hobbitRepository;

    public HobbitService(HobbitRepository hobbitRepository) {
        this.hobbitRepository = hobbitRepository;
    }
}
