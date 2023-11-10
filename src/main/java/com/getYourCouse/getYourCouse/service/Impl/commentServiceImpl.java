package com.getYourCouse.getYourCouse.service.Impl;

import com.getYourCouse.getYourCouse.dto.CommentDto;
import com.getYourCouse.getYourCouse.entities.Comment;
import com.getYourCouse.getYourCouse.entities.Courses;
import com.getYourCouse.getYourCouse.repositories.CommentRepository;
import com.getYourCouse.getYourCouse.repositories.CourseRepository;
import com.getYourCouse.getYourCouse.sec.entities.AppUser;
import com.getYourCouse.getYourCouse.sec.repo.AppUserRepository;
import com.getYourCouse.getYourCouse.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.getYourCouse.getYourCouse.mapper.CommentMapper.mapToComment;

@Service
@AllArgsConstructor
public class commentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private CourseRepository courseRepository;
    private AppUserRepository appUserRepository;
    @Override
    public Comment saveComment(Long courseId, String userId, CommentDto commentDto) {
        Courses course = courseRepository.findById(courseId).get();
        AppUser appUser = appUserRepository.findById(userId).get();
        Comment comment = mapToComment(commentDto);
        comment.setCourse(course);
        comment.setUser(appUser);
        return commentRepository.save(comment) ;
    }
}
