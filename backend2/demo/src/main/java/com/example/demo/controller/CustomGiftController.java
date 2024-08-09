package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.CustomGift;
import com.example.demo.repository.CustomGiftRepository;

@RestController
@RequestMapping("/api/custom-gifts")
public class CustomGiftController {

    @Autowired
    private CustomGiftRepository customGiftRepository;

    @PostMapping
    public ResponseEntity<CustomGift> createCustomGift(@RequestBody CustomGift customGift) {
        CustomGift savedCustomGift = customGiftRepository.save(customGift);
        return ResponseEntity.ok(savedCustomGift);
    }
}
