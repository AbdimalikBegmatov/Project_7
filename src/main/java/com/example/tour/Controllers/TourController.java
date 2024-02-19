package com.example.tour.Controllers;

import com.example.tour.Dto.Tour.TourResponseDetailDto;
import com.example.tour.Dto.Tour.TourResponseLiteDto;
import com.example.tour.Services.TourService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tour")
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public ResponseEntity<List<TourResponseLiteDto>> getAll(){
        return new ResponseEntity<>(tourService.getAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<TourResponseDetailDto> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(tourService.getById(id),HttpStatus.OK);
    }
}
