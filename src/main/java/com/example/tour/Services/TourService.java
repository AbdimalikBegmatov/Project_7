package com.example.tour.Services;


import com.example.tour.Dto.Tour.TourRequestDto;
import com.example.tour.Dto.Tour.TourResponseDetailDto;
import com.example.tour.Dto.Tour.TourResponseLiteDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TourService {
    List<TourResponseLiteDto> getAll();
    TourResponseDetailDto getById(Integer id);

    TourResponseDetailDto create(TourRequestDto request) throws IOException;
}
