package com.example.demo.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomGift;
import com.example.demo.repository.CustomGiftRepository;



@Service
public class CustomGiftService {

    @Autowired
    private CustomGiftRepository repository;

    public CustomGift saveCustomGift(CustomGift customGift) {
        return repository.save(customGift);
    }
}
