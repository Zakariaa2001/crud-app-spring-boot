package com.getYourCouse.getYourCouse.dto;

import com.getYourCouse.getYourCouse.entities.Courses;
import com.getYourCouse.getYourCouse.sec.entities.AppUser;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Builder
public class CommentDto {
    private Long id;
    private String comment;
    private Date createdAt;
    private Date updatedAt;
    private Courses course;
    private AppUser appuser;
}
