package com.example.tour.Dto.Tour;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class TourRequestDto {
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String country;
    @NotNull
    @NotBlank
    private String tourLocation;
    @NotNull
    @NotBlank
    private String description;
    private MultipartFile multipartFile;
    @NotNull
    private Integer category;
    @NotNull
    private LocalDate beginDate;
    @NotNull
    private LocalDate countOfDate;

    public TourRequestDto(String title, String country, String tourLocation, String description, Integer category, LocalDate beginDate, LocalDate countOfDate) {
        this.title = title;
        this.country = country;
        this.tourLocation = tourLocation;
        this.description = description;
        this.category = category;
        this.beginDate = beginDate;
        this.countOfDate = countOfDate;
    }
}
