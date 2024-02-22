package com.example.tour.Dto.Tour;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;


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
    private List<Integer> month;

    public TourRequestDto(String title, String country, String tourLocation, String description, Integer category, List<Integer> month) {
        this.title = title;
        this.country = country;
        this.tourLocation = tourLocation;
        this.description = description;
        this.category = category;
        this.month = month;
    }
}
