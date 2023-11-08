package com.getYourCouse.getYourCouse.mapper;

import com.getYourCouse.getYourCouse.dto.CategoryDto;
import com.getYourCouse.getYourCouse.dto.CourseDto;
import com.getYourCouse.getYourCouse.entities.Category;
import com.getYourCouse.getYourCouse.entities.Courses;

import java.util.stream.Collectors;

import static com.getYourCouse.getYourCouse.mapper.CategoryMapper.mapToCategory;

public class CourseMapper {
    public static Courses mapToCourse(CourseDto courses) {
        Courses courseDto = Courses.builder()
                .id(courses.getId())
                .title(courses.getTitle())
                .description(courses.getDescription())
                .image(courses.getImage())
                .createdAt(courses.getCreatedAt())
                .updatedAt(courses.getUpdatedAt())
                .deletedAt(courses.getDeletedAt())
                .build();
        return courseDto;
    }

    public static CourseDto mapToCourseDto(Courses course) {
            CourseDto courseDto = CourseDto.builder()
                    .id(course.getId())
                    .title(course.getTitle())
                    .description(course.getDescription())
                    .image(course.getImage())
                    .category(mapToCategoryDto(course.getCategory()))
                    .createdAt(course.getCreatedAt())
                    .updatedAt(course.getUpdatedAt())
                    .deletedAt(course.getDeletedAt())
                    .build();
            return courseDto;
    }
    public static CategoryDto mapToCategoryDto(Category category) {
        CategoryDto categoryDto = CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
        return categoryDto;
    }
}
