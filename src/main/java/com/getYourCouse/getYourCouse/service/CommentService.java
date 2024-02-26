package com.getYourCouse.getYourCouse.service;

import com.getYourCouse.getYourCouse.dto.CommentDto;
import com.getYourCouse.getYourCouse.entities.Comment;

public interface CommentService {
    Comment saveComment(Long courseId, String userName, CommentDto commentDto);
}
