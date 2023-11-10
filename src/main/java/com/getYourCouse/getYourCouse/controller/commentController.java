package com.getYourCouse.getYourCouse.controller;

import com.getYourCouse.getYourCouse.dto.CommentDto;
import com.getYourCouse.getYourCouse.entities.Comment;
import com.getYourCouse.getYourCouse.service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class commentController {

    private CommentService commentService;

    @GetMapping("/user/commentForm")
    public String commentForm(Model model) {
        model.addAttribute("comment",new Comment());
        return "course-details";
    }
    @PostMapping("/user/saveComment")
    public String saveComment(@Valid @ModelAttribute("comment") CommentDto commentDto,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "course-details";
        Long courseId = commentDto.getCourse().getId();
        String userId = "ok";
        commentService.saveComment(courseId,userId,commentDto);
        return "course-details";
    }
}
