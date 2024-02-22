package com.example.tour.Controllers;

import com.example.tour.Dto.Booking.BookingRequestDto;
import com.example.tour.Dto.Tour.TourResponseDetailDto;
import com.example.tour.Dto.Tour.TourResponseLiteDto;
import com.example.tour.Services.BookingService;
import com.example.tour.Services.TourService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tour")
public class TourController {

    private final TourService tourService;
    private final BookingService bookingService;

    public TourController(TourService tourService, BookingService bookingService) {
        this.tourService = tourService;
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<TourResponseLiteDto>> getAll(){
        return new ResponseEntity<>(tourService.getAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<TourResponseDetailDto> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(tourService.getById(id),HttpStatus.OK);
    }
    @GetMapping("recommended")
    public ResponseEntity<List<TourResponseLiteDto>> getRecommended(){
        return new ResponseEntity<>(tourService.getRecommended(),HttpStatus.OK);
    }
    @PostMapping("booking")
    public ResponseEntity<HttpStatus> booking(@RequestBody @Valid BookingRequestDto bookingRequestDto){
        return new ResponseEntity<>(bookingService.booking(bookingRequestDto),HttpStatus.OK);
    }
    @GetMapping("bycategory/{id}")
    public ResponseEntity<List<TourResponseLiteDto>> getByCategory(@PathVariable("id") Integer id){
        return new ResponseEntity<>(tourService.getByCategory(id),HttpStatus.OK);
    }
}
