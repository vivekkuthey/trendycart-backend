package com.vivek.trendycart.controller;

import com.vivek.trendycart.dto.ProductDTO;
import com.vivek.trendycart.entity.Product;
import com.vivek.trendycart.service.ProductService;
import com.vivek.trendycart.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // Constructor Injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // CREATE PRODUCT
    @PostMapping
    public ApiResponse<Product> saveProduct(
            @Valid @RequestBody ProductDTO productDTO) {

        return new ApiResponse<>(
                true,
                "Product created successfully",
                productService.saveProduct(productDTO)
        );
    }

    // GET ALL PRODUCTS
    @GetMapping
    public ApiResponse<List<Product>> getAllProducts() {

        return new ApiResponse<>(
                true,
                "Products fetched successfully",
                productService.getAllProducts()
        );
    }

    // SEARCH PRODUCT
    @GetMapping("/search")
    public ApiResponse<List<Product>> searchProducts(
            @RequestParam String name) {

        return new ApiResponse<>(
                true,
                "Products fetched successfully",
                productService.searchProducts(name)
        );
    }

    // GET PRODUCT BY ID
    @GetMapping("/{id}")
    public ApiResponse<Product> getProductById(
            @PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Product fetched successfully",
                productService.getProductById(id)
        );
    }

    // UPDATE PRODUCT
    @PutMapping("/{id}")
    public ApiResponse<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product updatedProduct) {

        return new ApiResponse<>(
                true,
                "Product updated successfully",
                productService.updateProduct(id, updatedProduct)
        );
    }

    // DELETE PRODUCT
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteProduct(
            @PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Product deleted successfully",
                productService.deleteProduct(id)
        );
    }
}
