package com.vivek.trendycart.repository;

import com.vivek.trendycart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

} 