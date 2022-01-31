package com.example.repository;

import com.example.entities.RentalProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DallasRentRepository extends JpaRepository<RentalProperty, BigDecimal> {
    @Query(value="SELECT a.mls ,a.rent ,a.lat, a.long, a.geometry FROM dallas_rent a", nativeQuery = true)
    List<RentalProperty> findAllRentalProperties();

    @Query(value="SELECT a.mls ,a.rent ,a.lat, a.long, a.geometry FROM dallas_rent a WHERE ST_Distance(a.geometry, ST_Point(:lon,:lat)) <= :radius", nativeQuery = true)
    List<RentalProperty> findAllRentalPropertiesWithin(@Param("lat") Double latitude, @Param("lon") Double longitude, @Param("radius") Double radius);

}
