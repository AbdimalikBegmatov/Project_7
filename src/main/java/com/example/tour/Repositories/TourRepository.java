package com.example.tour.Repositories;

import com.example.tour.Dto.Tour.TourResponseLiteDto;
import com.example.tour.Entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour,Integer> {
    @Query(" select new com.example.tour.Dto.Tour.TourResponseLiteDto(t.id,t.title,t.image) from Tour t")
    List<TourResponseLiteDto> findByLite();
}
