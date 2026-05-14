package com.vivek.trendycart.service.impl;

import com.vivek.trendycart.dto.ProductDTO;
import com.vivek.trendycart.entity.Product;
import com.vivek.trendycart.exception.ResourceNotFoundException;
import com.vivek.trendycart.repository.ProductRepository;
import com.vivek.trendycart.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // Constructor Injection
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CREATE PRODUCT
    @Override
    public Product saveProduct(ProductDTO productDTO) {

        Product product = new Product();

        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setCategory(productDTO.getCategory());

        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());

        product.setDescription(productDTO.getDescription());
        product.setImageUrl(productDTO.getImageUrl());

        product.setStorage(productDTO.getStorage());
        product.setRam(productDTO.getRam());
        product.setProcessor(productDTO.getProcessor());

        product.setWarranty(productDTO.getWarranty());

        return productRepository.save(product);
    }

    // GET ALL PRODUCTS
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET PRODUCT BY ID
    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found with id: " + id
                        ));
    }

    // UPDATE PRODUCT
    @Override
    public Product updateProduct(Long id, Product updatedProduct) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found with id: " + id
                        ));

        product.setName(updatedProduct.getName());
        product.setBrand(updatedProduct.getBrand());
        product.setCategory(updatedProduct.getCategory());

        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());

        product.setDescription(updatedProduct.getDescription());
        product.setImageUrl(updatedProduct.getImageUrl());

        product.setStorage(updatedProduct.getStorage());
        product.setRam(updatedProduct.getRam());
        product.setProcessor(updatedProduct.getProcessor());

        product.setWarranty(updatedProduct.getWarranty());

        return productRepository.save(product);
    }

    // DELETE PRODUCT
    @Override
    public String deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found with id: " + id
                        ));

        productRepository.delete(product);

        return "Product deleted successfully";
    }
}