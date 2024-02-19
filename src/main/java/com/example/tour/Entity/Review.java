package com.example.tour.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Review")
@Setter
@Getter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nickName",unique = true,nullable = false)
    private String nickName;
    @Column(name = "image")
    private String image;
    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "tour")
    private Tour tour;

    public Review(String nickName, String image, String comment, Tour tour) {
        this.nickName = nickName;
        this.image = image;
        this.comment = comment;
        this.tour = tour;
    }
}
