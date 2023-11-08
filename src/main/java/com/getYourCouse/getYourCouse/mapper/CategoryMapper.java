package com.getYourCouse.getYourCouse.mapper;

import com.getYourCouse.getYourCouse.dto.CategoryDto;
import com.getYourCouse.getYourCouse.entities.Category;

import java.util.stream.Collectors;

import static com.getYourCouse.getYourCouse.mapper.CourseMapper.mapToCourseDto;

public class CategoryMapper {
    public static Category mapToCategory(CategoryDto category) {
        Category categoryEntity = Category.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
        return categoryEntity;
    }
    public static CategoryDto mapToCategoryDto(Category category) {
        CategoryDto categoryDto = CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
        return categoryDto;
    }
}
