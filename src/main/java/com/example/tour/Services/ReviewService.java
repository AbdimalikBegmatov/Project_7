package com.example.tour.Services;

import com.example.tour.Dto.Review.ReviewRequestDto;
import org.springframework.http.HttpStatus;

import java.io.IOException;

public interface ReviewService {
    HttpStatus create(ReviewRequestDto requestDto) throws IOException;
}
