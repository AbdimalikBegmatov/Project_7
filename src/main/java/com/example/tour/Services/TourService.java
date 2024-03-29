package com.example.tour.Services;


import com.example.tour.Dto.Tour.TourRequestDto;
import com.example.tour.Dto.Tour.TourResponseDetailDto;
import com.example.tour.Dto.Tour.TourResponseLiteDto;

import java.io.IOException;
import java.util.List;

public interface TourService {
    List<TourResponseLiteDto> getAll();
    TourResponseDetailDto getById(Integer id);

    TourResponseDetailDto create(TourRequestDto request) throws IOException;

    List<TourResponseLiteDto> getRecommended();

    List<TourResponseLiteDto> getByCategory(Integer id);
}
