package com.event.p1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.p1.repository.foodRepository;

@Service
public class foodService {
    @Autowired
    private foodRepository foodrepository;
}
