package com.getYourCouse.getYourCouse.repositories;

import com.getYourCouse.getYourCouse.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query("SELECT c FROM Comment c WHERE c.course.id = :courseId")
    List<Comment> findCommentsByCourseId(@Param("courseId") Long courseId);
}
