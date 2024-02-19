package com.example.tour.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "Tour")
@Setter
@Getter
@NoArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title",nullable = false,unique = true)
    private String title;
    @Column(name = "country",nullable = false)
    private String country;
    @Column(name = "tourLocation",nullable = false)
    private String tourLocation;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "image")
    private String image;

    @Column(name = "beginDate",nullable = false)
    private LocalDate beginDate;
    @Column(name = "countOfDay",nullable = false)
    private LocalDate countOfDay;

    @OneToMany(mappedBy = "tour")
    private Collection<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "category",nullable = false)
    private Category category;

    public Tour(String title, String country, String tourLocation, String description, String image, LocalDate beginDate, LocalDate countOfDay, Category category) {
        this.title = title;
        this.country = country;
        this.tourLocation = tourLocation;
        this.description = description;
        this.image = image;
        this.beginDate = beginDate;
        this.countOfDay = countOfDay;
        this.category = category;
    }
}
