package com.example.tour.Exeptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ApiError {
    private Integer statusCode;
    private LocalDateTime dateTime;
    private Map<String,String> fields;

    public ApiError(HttpStatus httpStatus, LocalDateTime dateTime, Map<String,String> fields) {
        this.statusCode = httpStatus.value();
        this.dateTime = dateTime;
        this.fields = fields;
    }
}
