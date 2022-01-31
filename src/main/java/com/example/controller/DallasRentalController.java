package com.example.controller;

import com.example.Exceptions.NoPropertyFoundException;
import com.example.entities.RentalProperty;
import com.example.response.CustomResponseHandler;
import com.example.service.DallasRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/props")
public class DallasRentalController {
    @Autowired
    private DallasRentalService dallasRentalService;

    @CrossOrigin(origins = "*")
    @GetMapping()
    public ResponseEntity<Object> findAll() {
        List<RentalProperty> result = dallasRentalService.findAllRentalProperties();
        if(result == null || result.isEmpty()){
            throw new NoPropertyFoundException();
        }
        return CustomResponseHandler.generateResponse("Properties Found", HttpStatus.OK, result);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{lat}/{lon}/{range}")
    public ResponseEntity<Object> findWithin(@PathVariable Double lat, @PathVariable Double lon, @PathVariable Double range) {
        List<RentalProperty> result = dallasRentalService.findAllRentalPropertiesWithin(lat, lon, range);
        if(result == null || result.isEmpty()){
            throw new NoPropertyFoundException();
        }
        return CustomResponseHandler.generateResponse("Properties Found", HttpStatus.OK, result);
    }
}
