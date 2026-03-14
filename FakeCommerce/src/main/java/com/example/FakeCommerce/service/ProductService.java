package com.example.FakeCommerce.service;


import com.example.FakeCommerce.aop.TrackTime;
import com.example.FakeCommerce.dtos.products.ProductRequestDto;
import com.example.FakeCommerce.dtos.products.ProductResponseDto;
import com.example.FakeCommerce.dtos.products.ProductWithDetailsResponseDto;
import com.example.FakeCommerce.repository.ProductRepository;
import com.example.FakeCommerce.schema.Category;
import com.example.FakeCommerce.schema.Product;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @TrackTime(" get-all-products ")
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> ProductResponseDto.builder()
                        .id(product.getId())
                        .title(product.getTitle())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .image(product.getImage())
                        .rating(product.getRating())
                        .build())
                .collect(Collectors.toList());
    }

    public ProductResponseDto getProductById(Long id) {
        return productRepository.findById(id)
                .map(product -> ProductResponseDto.builder()
                        .id(product.getId())
                        .title(product.getTitle())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .image(product.getImage())
                        .rating(product.getRating())
                        .build())
                .orElseThrow(() -> new RuntimeException("product not found"));
    }


    public ProductWithDetailsResponseDto getProductWithDetailsById(Long id) {
        Product product = productRepository.findProductWithDetailsById(id).get(0);

        return ProductWithDetailsResponseDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory().getName())
                .image(product.getImage())
                .rating(product.getRating())
                .build();
    }


    public Product createProduct(ProductRequestDto requestDto) {

        Category category = categoryService.getCategoryById(requestDto.getCategoryId());

        Product newProduct = Product.builder()
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .image(requestDto.getImage())
                .price(requestDto.getPrice())
                .category(category)
                .rating(requestDto.getRating())
                .build();

        return productRepository.save(newProduct);
    }


    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory_Name(category);
    }

    public List<String> getAllCategories() {
        return productRepository.findAllCategories();
    }
}