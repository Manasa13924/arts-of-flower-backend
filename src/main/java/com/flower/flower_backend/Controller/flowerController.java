package com.flower.flower_backend.Controller;

import com.flower.flower_backend.model.flower;
import com.flower.flower_backend.repository.flowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class flowerController {

    @Autowired
    private flowerRepository flowerRepository;

    @GetMapping
    public Page<flower> getFlowers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
            @RequestParam(defaultValue = "") String search) {

        Pageable pageable = PageRequest.of(page, size);

        if (search.isEmpty()) {
            return flowerRepository.findAll(pageable);
        } else {
            return flowerRepository.findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(search, search, pageable);
        }
    }
}