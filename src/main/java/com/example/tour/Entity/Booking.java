package com.example.tour.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Booking")
@Setter
@Getter
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "countOfPeople")
    private Integer countOfPeople;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "comment")
    private String comment;
    @Column(name = "tourId")
    private Integer tourId;

    public Booking(Integer countOfPeople, String phoneNumber, String comment, Integer tourId) {
        this.countOfPeople = countOfPeople;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.tourId = tourId;
    }
}
