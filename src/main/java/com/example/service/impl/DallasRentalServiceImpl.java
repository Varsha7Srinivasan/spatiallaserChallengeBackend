package com.example.service.impl;

import com.example.entities.RentalProperty;
import com.example.repository.DallasRentRepository;
import com.example.service.DallasRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DallasRentalServiceImpl implements DallasRentalService {
    @Autowired
    private DallasRentRepository dallasRentRepository;


    @Override
    public List<RentalProperty> findAllRentalProperties() {
        return dallasRentRepository.findAllRentalProperties();
    }

    public List<RentalProperty> findAllRentalPropertiesWithin(Double lat, Double lon, Double radius) {
        return dallasRentRepository.findAllRentalPropertiesWithin(lat, lon, radius);
    }
}
