package com.example.tour.Services;

import com.example.tour.Dto.Booking.BookingRequestDto;
import org.springframework.http.HttpStatus;

public interface BookingService {
    HttpStatus booking(BookingRequestDto bookingRequestDto);
}
