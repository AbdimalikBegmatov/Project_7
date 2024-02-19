package com.example.tour.Services.Impl;

import com.example.tour.Dto.Booking.BookingRequestDto;
import com.example.tour.Entity.Booking;
import com.example.tour.Exeptions.CustomNotFoundException;
import com.example.tour.Repositories.BookingRepository;
import com.example.tour.Repositories.TourRepository;
import com.example.tour.Services.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final TourRepository tourRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, TourRepository tourRepository) {
        this.bookingRepository = bookingRepository;
        this.tourRepository = tourRepository;
    }

    @Override
    public HttpStatus booking(BookingRequestDto bookingRequestDto) {
        if (!tourRepository.existsById(bookingRequestDto.getTourId())){
            throw new CustomNotFoundException(
                    String.format("Tour with this id={%s} not found",bookingRequestDto.getTourId()
                    ));
        }
        Booking booking = bookingRepository.save(
                new Booking(
                        bookingRequestDto.getCountOfPeople(),
                        bookingRequestDto.getPhoneNumber(),
                        bookingRequestDto.getComment(),
                        bookingRequestDto.getTourId()));
        if (booking.getId() == null){
            throw new RuntimeException("Error from saving");
        }
        return HttpStatus.CREATED;
    }
}
