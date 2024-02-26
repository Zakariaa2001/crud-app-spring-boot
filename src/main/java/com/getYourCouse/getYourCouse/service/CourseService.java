package com.getYourCouse.getYourCouse.service;

import com.getYourCouse.getYourCouse.dto.CategoryDto;
import com.getYourCouse.getYourCouse.dto.CommentDto;
import com.getYourCouse.getYourCouse.dto.CourseDto;
import com.getYourCouse.getYourCouse.entities.Courses;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAllCourses();
    Courses saveCourse(Long categoryId ,CourseDto courseDto);

    CourseDto findCourseById(Long courseId);

    List<CommentDto> findCoursesByComment(Long commentId);

    void updateCourse(CourseDto course);

    void delete(Long courseId);
    List<CourseDto> searchCourses(String query);

    List<CategoryDto> getAllCategories();

}
