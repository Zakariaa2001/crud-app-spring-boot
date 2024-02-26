package com.getYourCouse.getYourCouse.mapper;

import com.getYourCouse.getYourCouse.dto.CategoryDto;
import com.getYourCouse.getYourCouse.dto.CommentDto;
import com.getYourCouse.getYourCouse.entities.Category;
import com.getYourCouse.getYourCouse.entities.Comment;

public class CommentMapper {
    public static Comment mapToComment(CommentDto commentDto) {
        Comment comment = Comment.builder()
                .id(commentDto.getId())
                .comment(commentDto.getComment())
                .course(commentDto.getCourse())
                .user(commentDto.getAppuser())
                .build();
        return comment;
    }
    public static CommentDto mapToCommentDto(Comment comment) {
        CommentDto commentDto = CommentDto.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .course(comment.getCourse())
                .appuser(comment.getUser())
                .build();
        return commentDto;
    }
}
