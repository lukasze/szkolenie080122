package com.example.hobbitron.hobbit;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbitService {

    private HobbitRepository hobbitRepository;

    public HobbitService(HobbitRepository hobbitRepository) {
        this.hobbitRepository = hobbitRepository;
    }

    public List<Hobbit> findAll() {
        return hobbitRepository.findAll();
    }
}
