package com.example.service;

import com.example.entities.RentalProperty;


import java.util.List;


public interface DallasRentalService {
    List<RentalProperty> findAllRentalProperties();
    List<RentalProperty> findAllRentalPropertiesWithin(Double lat, Double lon, Double radius);
}
