package com.example.tour.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.List;

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
    @Column(name = "description",nullable = false,length = 1000)
    private String description;
    @Column(name = "image")
    private String image;

    @Column(name = "month",nullable = false)
    private Collection<Month> month;

    @OneToMany(mappedBy = "tour")
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "category",nullable = false)
    private Category category;

    public Tour(String title, String country, String tourLocation, String description, String image, List<Month> month, Category category) {
        this.title = title;
        this.country = country;
        this.tourLocation = tourLocation;
        this.description = description;
        this.image = image;
        this.month = month;
        this.category = category;
    }
}
