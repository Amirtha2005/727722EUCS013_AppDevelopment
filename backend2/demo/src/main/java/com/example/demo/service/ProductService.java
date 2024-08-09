package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo prepo;

     public List<Product> getAllFrames() {
        return prepo.findAll();
    }

    public Product getFrameById(Long id) {
        return prepo.findById(id).orElse(null);
    }

    public Product saveFrame(Product frame) {
        return prepo.save(frame);
    }

    public void deleteFrame(Long id) {
        prepo.deleteById(id);
    }

    public List<Product> saveAllFrames(List<Product> frames) {
        return prepo.saveAll(frames);
    }
}
