package com.example.tour.Dto.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryRequestDto {
    @NotBlank
    private String title;

    public CategoryRequestDto(@NotNull String title) {
        this.title = title;
    }
}
