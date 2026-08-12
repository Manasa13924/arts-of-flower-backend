package com.flower.flower_backend.repository;

import com.flower.flower_backend.model.flower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface flowerRepository extends JpaRepository<flower, Long> {
    Page<flower> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(String name, String category, Pageable pageable);
}