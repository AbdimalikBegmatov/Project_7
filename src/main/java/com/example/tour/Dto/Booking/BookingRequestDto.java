package com.example.tour.Dto.Booking;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDto {
    @Range(min = 1,message = "There must be at least 1 people")
    private Integer countOfPeople;
    @NotBlank
    @Pattern(regexp = "^\\d{10}$")
    private String phoneNumber;
    private String comment;
    @NotNull(message = "tour must be selected")
    private Integer tourId;
}
