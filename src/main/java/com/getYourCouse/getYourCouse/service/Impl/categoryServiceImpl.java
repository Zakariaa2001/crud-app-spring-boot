package com.getYourCouse.getYourCouse.service.Impl;

import com.getYourCouse.getYourCouse.dto.CategoryDto;
import com.getYourCouse.getYourCouse.entities.Category;
import com.getYourCouse.getYourCouse.repositories.CategoryRepository;
import com.getYourCouse.getYourCouse.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.getYourCouse.getYourCouse.mapper.CategoryMapper.mapToCategory;
import static com.getYourCouse.getYourCouse.mapper.CategoryMapper.mapToCategoryDto;

@Service
@AllArgsConstructor
public class categoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    @Override
    public Category saveCategory(CategoryDto categoryDto) {
        Category category = mapToCategory(categoryDto);
        return categoryRepository.save(category);
    }

    @Override
    public  List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map((category) -> mapToCategoryDto(category)).collect(Collectors.toList());

    }

    @Override
    public CategoryDto findCourseById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).get();
        return mapToCategoryDto(category);
    }

    @Override
    public void updateCategory(CategoryDto categoryDto) {
        Category category = mapToCategory(categoryDto);
        categoryRepository.save(category);
    }


}
