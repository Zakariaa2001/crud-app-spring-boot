package com.getYourCouse.getYourCouse.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
public class CategoryDto {
    private Long id;
    private String name;
}
