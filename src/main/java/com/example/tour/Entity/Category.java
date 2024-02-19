package com.example.tour.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
@Entity
@Table(name = "Category")
@Setter
@Getter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title",nullable = false,unique = true)
    private String title;

    @OneToMany(mappedBy = "category")
    private Collection<Tour> tours;

    public Category(String title) {
        this.title = title;
    }
}
