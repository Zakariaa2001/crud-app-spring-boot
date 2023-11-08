package com.getYourCouse.getYourCouse.service.Impl;

import com.getYourCouse.getYourCouse.dto.CategoryDto;
import com.getYourCouse.getYourCouse.dto.CourseDto;
import com.getYourCouse.getYourCouse.entities.Category;
import com.getYourCouse.getYourCouse.entities.Courses;
import com.getYourCouse.getYourCouse.repositories.CategoryRepository;
import com.getYourCouse.getYourCouse.repositories.CourseRepository;
import com.getYourCouse.getYourCouse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.getYourCouse.getYourCouse.mapper.CourseMapper.*;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    private CategoryRepository categoryRepository;

    public CourseServiceImpl(CourseRepository courseRepository, CategoryRepository categoryRepository) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CourseDto> findAllCourses() {
        List<Courses> courses = courseRepository.findAll();
        return courses.stream().map((course) -> mapToCourseDto(course)).collect(Collectors.toList());
    }

    @Override
    public Courses saveCourse(Long categoryId,CourseDto courseDto) {
        Category category = categoryRepository.findById(categoryId).get();
        Courses course = mapToCourse(courseDto);
        course.setCategory(category);
        return courseRepository.save(course);
    }

    @Override
    public CourseDto findCourseById(Long courseId) {
        Courses course = courseRepository.findById(courseId).get();
        return mapToCourseDto(course);
    }

    @Override
    public void updateCourse(CourseDto courseDto) {
        Courses course = mapToCourse(courseDto);
        courseRepository.save(course);
    }

    @Override
    public void delete(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<CourseDto> searchCourses(String query) {
        List<Courses> courses = courseRepository.searchCourses(query);
        return courses.stream().map(course -> mapToCourseDto(course)).collect(Collectors.toList());
    }

    @Override
    public  List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map((category) -> mapToCategoryDto(category)).collect(Collectors.toList());
    }


}
