package com.vivek.trendycart.service;

import com.vivek.trendycart.dto.ProductDTO;
import com.vivek.trendycart.entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(ProductDTO productDTO);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Long id,
                          Product updatedProduct);

    String deleteProduct(Long id);

    List<Product> searchProducts(String name);

}