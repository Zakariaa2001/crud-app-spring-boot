package com.getYourCouse.getYourCouse.repositories;

import com.getYourCouse.getYourCouse.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Courses,Long> {

    @Query("SELECT c From Courses c WHERE c.title LIKE CONCAT('%',:query,'%')")
    List<Courses> searchCourses(String query);
}
