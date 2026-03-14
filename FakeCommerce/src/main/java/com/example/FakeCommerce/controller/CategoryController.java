package com.example.FakeCommerce.controller;


import com.example.FakeCommerce.dtos.api.ApiResponse;
import com.example.FakeCommerce.dtos.category.CategoryRequestDto;
import com.example.FakeCommerce.schema.Category;
import com.example.FakeCommerce.service.CategoryService;
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

        ApiResponse<Category> response =
                new ApiResponse<>(true, "Category created successfully", category, null);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
