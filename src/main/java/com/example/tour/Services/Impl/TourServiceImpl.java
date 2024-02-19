package com.example.tour.Services.Impl;

import com.example.tour.Dto.Review.ReviewResponseDto;
import com.example.tour.Dto.Tour.TourRequestDto;
import com.example.tour.Dto.Tour.TourResponseDetailDto;
import com.example.tour.Dto.Tour.TourResponseLiteDto;
import com.example.tour.Entity.Category;
import com.example.tour.Entity.Tour;
import com.example.tour.Exeptions.CustomNotFoundException;
import com.example.tour.Repositories.CategoryRepository;
import com.example.tour.Repositories.TourRepository;
import com.example.tour.Services.CloudinaryService;
import com.example.tour.Services.TourService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;
    private final CloudinaryService cloudinaryService;
    private final CategoryRepository categoryRepository;

    public TourServiceImpl(TourRepository tourRepository, CloudinaryService cloudinaryService, CategoryRepository categoryRepository) {
        this.tourRepository = tourRepository;
        this.cloudinaryService = cloudinaryService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<TourResponseLiteDto> getAll() {
        return tourRepository.findByLite();
    }

    @Override
    public TourResponseDetailDto getById(Integer id) {
        return tourRepository
                .findById(id)
                .map(tour ->
                        new TourResponseDetailDto(
                                tour.getId(),
                                tour.getTitle(),
                                tour.getCountry(),
                                tour.getTourLocation(),
                                tour.getDescription(),
                                tour.getImage(),
                                tour.getCategory().getTitle(),
                                tour.getBeginDate(),
                                tour.getCountOfDay(),
                                tour.getReviews()
                                        .stream()
                                        .map(review->{
                                  return new ReviewResponseDto(
                                            review.getId(),
                                            review.getNickName(),
                                            review.getImage(),
                                            review.getComment());
                                }).toList()))
                .orElseThrow(()->new CustomNotFoundException("Tour not found"));
    }

    @Override
    @Transactional
    public TourResponseDetailDto create(TourRequestDto request) throws IOException {
        MultipartFile multipartFile = request.getMultipartFile();
        if (multipartFile.isEmpty()){
            throw new RuntimeException("Image can`t be empty");
        }
        String imageUrl = cloudinaryService.uploadImage(multipartFile);

        Category category = categoryRepository
                .findById(
                        request.getCategory())
                .orElseThrow(()->
                        new CustomNotFoundException(
                                String.format("category with {%S} is not found",
                                        request.getCategory())));

        Tour tour = tourRepository.save(
                new Tour(
                        request.getTitle(),
                        request.getCountry(),
                        request.getTourLocation(),
                        request.getDescription(),
                        imageUrl,
                        request.getBeginDate(),
                        request.getCountOfDate(),
                        category));

        return new TourResponseDetailDto(
                tour.getId(),
                tour.getTitle(),
                tour.getCountry(),
                tour.getTourLocation(),
                tour.getDescription(),
                tour.getImage(),
                tour.getCategory().getTitle(),
                tour.getBeginDate(),
                tour.getCountOfDay(),
                tour.getReviews()
                        .stream()
                        .map(review->{
                            return new ReviewResponseDto(
                                    review.getId(),
                                    review.getNickName(),
                                    review.getImage(),
                                    review.getComment());
                        }).toList());
    }
}
