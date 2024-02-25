package com.example.tour.Controllers;

import com.example.tour.Dto.Category.CategoryRequestDto;
import com.example.tour.Dto.Category.CategoryResponseDto;
import com.example.tour.Dto.Review.ReviewRequestDto;
import com.example.tour.Dto.Tour.TourRequestDto;
import com.example.tour.Dto.Tour.TourResponseDetailDto;
import com.example.tour.Services.CategoryService;
import com.example.tour.Services.ReviewService;
import com.example.tour.Services.TourService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    private final TourService tourService;
    private final CategoryService categoryService;
    private final ReviewService reviewService;

    public AdminController(TourService tourService, CategoryService categoryService, ReviewService reviewService) {
        this.tourService = tourService;
        this.categoryService = categoryService;
        this.reviewService = reviewService;
    }

    @PostMapping(value = "tour")
    public ResponseEntity<TourResponseDetailDto> create(@RequestBody @Valid TourRequestDto request) throws IOException {
        return new ResponseEntity<>(tourService.create(request), HttpStatus.CREATED);
    }

    @PostMapping("category")
    public ResponseEntity<CategoryResponseDto> create(@RequestBody @Valid CategoryRequestDto categoryRequestDto){
        return new ResponseEntity<>(categoryService.create(categoryRequestDto),HttpStatus.CREATED);
    }
    @PostMapping("review")
    public ResponseEntity<HttpStatus> create(@RequestPart("request") @Valid ReviewRequestDto requestDto, @RequestPart("image")MultipartFile image) throws IOException {
        requestDto.setImage(image);
        return new ResponseEntity<>(reviewService.create(requestDto),HttpStatus.CREATED);
    }

}
