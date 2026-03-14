package com.example.FakeCommerce.service;


import com.example.FakeCommerce.dtos.category.CategoryRequestDto;
import com.example.FakeCommerce.repository.CategoryRepository;
import com.example.FakeCommerce.schema.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(CategoryRequestDto requestDto) {
        Category newCategory = Category.builder()
                .name(requestDto.getName())
                .build();

        return categoryRepository.save(newCategory);
    }


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
