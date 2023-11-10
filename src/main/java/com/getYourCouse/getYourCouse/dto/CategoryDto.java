package com.getYourCouse.getYourCouse.dto;


import com.getYourCouse.getYourCouse.entities.Category;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
public class CategoryDto{
    private Long id;
    private String name;
}
