package com.getYourCouse.getYourCouse.service;

import com.getYourCouse.getYourCouse.dto.CategoryDto;
import com.getYourCouse.getYourCouse.dto.CourseDto;
import com.getYourCouse.getYourCouse.entities.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();
    CategoryDto findCourseById(Long categoryId);

    void updateCategory(CategoryDto categoryDto);
}
