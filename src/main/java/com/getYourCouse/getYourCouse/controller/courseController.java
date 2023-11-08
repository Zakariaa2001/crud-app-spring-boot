package com.getYourCouse.getYourCouse.controller;


import com.getYourCouse.getYourCouse.dto.CategoryDto;
import com.getYourCouse.getYourCouse.dto.CourseDto;
import com.getYourCouse.getYourCouse.entities.Category;
import com.getYourCouse.getYourCouse.entities.Courses;
import com.getYourCouse.getYourCouse.repositories.CategoryRepository;
import com.getYourCouse.getYourCouse.repositories.CourseRepository;
import com.getYourCouse.getYourCouse.service.CategoryService;
import com.getYourCouse.getYourCouse.service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
//@AllArgsConstructor
public class courseController {

    private CourseService courseService;

    public courseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/403")
    public String notAuthorized() {
        return "403";
    }
    @GetMapping("/")
    public String courses(Model model) {
        List<CourseDto> courses = courseService.findAllCourses();
        model.addAttribute("courses",courses);
        return "index";
    }
    @GetMapping("/admin/course/{courseId}/delete")
    public String deleteCourse(@PathVariable("courseId") Long courseId ) {
        courseService.delete(courseId);
        return "redirect:/";
    }
    @GetMapping("/user/course/{courseId}")
    public String courseDetails(@PathVariable("courseId") Long courseId,Model model) {
        CourseDto courseDto = courseService.findCourseById(courseId);
        model.addAttribute("course",courseDto);
        return "course-details";
    }
    @GetMapping("/admin/addCourse")
    public String add(Model model) {
        List<CategoryDto> categories = courseService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("course",new Courses());
        return "addCourse";
    }
    @PostMapping("admin/save")
    public String saveCourse(@Valid @ModelAttribute("courses") CourseDto courseDto,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "addCourse";
        Long categoryId = courseDto.getCategory().getId();
        courseService.saveCourse(categoryId,courseDto);
        return "redirect:/";
    }

    @GetMapping("/admin/course/{courseId}/edit")
    public String editCourseForm(@PathVariable("courseId") Long courseId, Model model) {
        CourseDto course = courseService.findCourseById(courseId);
        model.addAttribute("course",course);
        return "course-edit";

    }
    @PostMapping("/admin/course/{courseId}/edit")
    public String updateCourse(@PathVariable("courseId") Long courseId,
                               @Valid @ModelAttribute("course") CourseDto course,
                               BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return  "course-edit";
        }
        course.setId(courseId);
        courseService.updateCourse(course);
        return "redirect:/";
    }
    @GetMapping("/user/courses/search")
    public String searchCourse(@RequestParam(value = "query") String query, Model model) {
        List<CourseDto> courseDtos = courseService.searchCourses(query);
        model.addAttribute("courses",courseDtos);
        return "index";
    }

}
