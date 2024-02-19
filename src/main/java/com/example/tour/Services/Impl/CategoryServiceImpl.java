package com.example.tour.Services.Impl;

import com.example.tour.Dto.Category.CategoryRequestDto;
import com.example.tour.Dto.Category.CategoryResponseDto;
import com.example.tour.Entity.Category;
import com.example.tour.Repositories.CategoryRepository;
import com.example.tour.Services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryResponseDto> getAll() {
        return categoryRepository
                .findAll()
                .stream()
                .map(entity->{
            return new CategoryResponseDto(
                    entity.getId(),
                    entity.getTitle());
        }).toList();
    }

    @Override
    public CategoryResponseDto create(CategoryRequestDto categoryRequestDto) {
        Category category = categoryRepository.save(new Category(categoryRequestDto.getTitle()));
        return new CategoryResponseDto(category.getId(), category.getTitle());
    }
}
