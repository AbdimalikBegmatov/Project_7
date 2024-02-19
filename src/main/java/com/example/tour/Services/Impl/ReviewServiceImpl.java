package com.example.tour.Services.Impl;

import com.example.tour.Dto.Review.ReviewRequestDto;
import com.example.tour.Entity.Review;
import com.example.tour.Entity.Tour;
import com.example.tour.Exeptions.CustomNotFoundException;
import com.example.tour.Repositories.ReviewRepository;
import com.example.tour.Repositories.TourRepository;
import com.example.tour.Services.CloudinaryService;
import com.example.tour.Services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final TourRepository tourRepository;
    private final CloudinaryService cloudinaryService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, TourRepository tourRepository, CloudinaryService cloudinaryService) {
        this.reviewRepository = reviewRepository;
        this.tourRepository = tourRepository;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    @Transactional
    public HttpStatus create(ReviewRequestDto requestDto) throws IOException {

        if (requestDto.getImage().getSize()==0){
            throw new RuntimeException("Image can`t be empty");
        }

        Optional<Tour> tour = tourRepository.findById(requestDto.getTour());
        if (tour.isEmpty()){
            throw new CustomNotFoundException(String.format("Tour with id={%s} not found",requestDto.getTour()));
        }
        String imageUrl = cloudinaryService.uploadImage(requestDto.getImage());

        reviewRepository.save(
                new Review(
                        requestDto.getNickName(),
                        imageUrl,
                        requestDto.getComment(),
                        tour.get()));

        return HttpStatus.CREATED;
    }
}
