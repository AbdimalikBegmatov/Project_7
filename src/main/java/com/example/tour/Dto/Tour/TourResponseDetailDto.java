package com.example.tour.Dto.Tour;

import com.example.tour.Entity.Review;
import lombok.Data;

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
    private List<String> month;
    private List<Review> reviewsDtoList;

    public TourResponseDetailDto(Integer id, String title, String country, String tourLocation, String description, String image, String category, List<String> month, List<Review> reviewsDtoList) {
        this.id = id;
        this.title = title;
        this.country = country;
        this.tourLocation = tourLocation;
        this.description = description;
        this.image = image;
        this.category = category;
        this.month = month;
        this.reviewsDtoList = reviewsDtoList;
    }
}
