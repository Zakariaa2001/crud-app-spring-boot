package com.getYourCouse.getYourCouse.repositories;

import com.getYourCouse.getYourCouse.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
