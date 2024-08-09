package com.example.demo.repository;

import com.example.demo.model.CustomGift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomGiftRepository extends JpaRepository<CustomGift, Long> {
}
