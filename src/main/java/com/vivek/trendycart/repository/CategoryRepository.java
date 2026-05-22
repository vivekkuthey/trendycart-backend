package com.vivek.trendycart.repository;

import com.vivek.trendycart.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
        extends JpaRepository<Category, Long> {
}