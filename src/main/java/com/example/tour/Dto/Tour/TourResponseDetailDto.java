package com.example.tour.Dto.Tour;

import com.example.tour.Dto.Review.ReviewResponseDto;
import com.example.tour.Entity.Review;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
public class TourResponseDetailDto {
    private Integer id;
    private String title;
    private String country;
    private String tourLocation;
    private String description;
    private String image;
    private String category;
    private LocalDate beginDate;
    private LocalDate endDay;
    private Collection<ReviewResponseDto> responseDtoList;

    public TourResponseDetailDto(Integer id, String title, String country, String tourLocation, String description, String image, String category, LocalDate beginDate, LocalDate endDay, Collection<ReviewResponseDto> responseDtoList) {
        this.id = id;
        this.title = title;
        this.country = country;
        this.tourLocation = tourLocation;
        this.description = description;
        this.image = image;
        this.category = category;
        this.beginDate = beginDate;
        this.endDay = endDay;
        this.responseDtoList = responseDtoList;
    }
}
