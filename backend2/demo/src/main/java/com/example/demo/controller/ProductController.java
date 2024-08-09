package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

     @Autowired
    private ProductService pService;

    @GetMapping
    public List<Product> getAllFrames() {
        return pService.getAllFrames();
    }

    @GetMapping("/{id}")
    public Product getFrameById(@PathVariable Long id) {
        return pService.getFrameById(id);
    }

    @PostMapping("/items")
    public Product createFrame(@RequestBody Product frame) {
        return pService.saveFrame(frame);
    }

    @PostMapping("/bulk")
    public List<Product> createFrames(@RequestBody List<Product> frames) {
        return pService.saveAllFrames(frames);
    }

    @PutMapping("/{id}")
    public Product updateFrame(@PathVariable Long id, @RequestBody Product frame) {
        frame.setId(id);
        return pService.saveFrame(frame);
    }

    @DeleteMapping("/{id}")
    public void deleteFrame(@PathVariable Long id) {
        pService.deleteFrame(id);
    }
}
