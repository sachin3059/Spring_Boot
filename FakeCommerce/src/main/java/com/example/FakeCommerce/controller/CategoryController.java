package com.example.FakeCommerce.controller;


import com.example.FakeCommerce.dtos.category.CategoryRequestDto;
import com.example.FakeCommerce.schema.Category;
import com.example.FakeCommerce.service.CategoryService;
import com.example.FakeCommerce.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<Category>> createCategory(
            @RequestBody CategoryRequestDto requestDto){

        Category category = categoryService.createCategory(requestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(category, "Created Category"));
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<Category>>> getCategories(){

        return ResponseEntity
                .ok(ApiResponse.success(categoryService.getAllCategories(), "Categories fetched successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> getCategoryById(@PathVariable Long id){
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity
                .ok(ApiResponse.success(category, "Category fetched successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity
                .ok(ApiResponse.success(null, "Category deleted successfully"));
    }
}
