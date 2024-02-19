package com.example.tour.Dto.Review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ReviewRequestDto {
    @NotNull
    @NotBlank
    private String nickName;
    private MultipartFile image;
    @NotNull
    private Integer tour;
    @NotNull
    @NotBlank
    private String comment;

    public ReviewRequestDto(String nickName, Integer tour, String comment) {
        this.nickName = nickName;
        this.tour = tour;
        this.comment = comment;
    }
}
