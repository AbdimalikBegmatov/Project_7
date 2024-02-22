package com.example.tour.Repositories;

import com.example.tour.Dto.Tour.TourResponseLiteDto;
import com.example.tour.Entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour,Integer> {
    @Query(" select new com.example.tour.Dto.Tour.TourResponseLiteDto(t.id,t.title,t.image) from Tour t")
    List<TourResponseLiteDto> findByLite();

    @Query(value = "select * from Tour t where ?1 = ANY (t.month)",nativeQuery = true)
    List<Tour> findRecommended(@Param("month") Integer month);
@Query(value = "select new com.example.tour.Dto.Tour.TourResponseLiteDto(t.id,t.title,t.image) from Tour t where t.category.id = :categoryId")
    List<TourResponseLiteDto> findByCategory(@Param("categoryId") Integer id);
}
