package com.example.FakeCommerce.controller;


import com.example.FakeCommerce.dtos.products.ProductRequestDto;
import com.example.FakeCommerce.dtos.products.ProductResponseDto;
import com.example.FakeCommerce.dtos.products.ProductWithDetailsResponseDto;
import com.example.FakeCommerce.schema.Product;
import com.example.FakeCommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/{id}/details")
    public ProductWithDetailsResponseDto getProductDetailById(@PathVariable Long id){
        return productService.getProductWithDetailsById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductRequestDto requestDto){
        return productService.createProduct(requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/search")
    public List<Product> getProductsByCategory(@RequestParam("categoryName") String categoryName){
        return productService.getProductsByCategory(categoryName);
    }

    @GetMapping("/categories")
    public List<String> getAllCategories(){
        return productService.getAllCategories();
    }

}
