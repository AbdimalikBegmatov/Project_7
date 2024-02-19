package com.example.tour.Services;

import com.example.tour.Dto.Category.CategoryRequestDto;
import com.example.tour.Dto.Category.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> getAll();

    CategoryResponseDto create(CategoryRequestDto categoryRequestDto);
}
