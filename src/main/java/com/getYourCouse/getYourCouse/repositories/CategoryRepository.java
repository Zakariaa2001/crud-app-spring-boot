package com.getYourCouse.getYourCouse.repositories;

import com.getYourCouse.getYourCouse.entities.Category;
import com.getYourCouse.getYourCouse.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT c From Category c WHERE c.name LIKE CONCAT('%',:query,'%')")
    List<Category> searchCategory(String query);
}
