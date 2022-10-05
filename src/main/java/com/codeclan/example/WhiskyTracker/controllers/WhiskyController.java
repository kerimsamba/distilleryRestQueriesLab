package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whisky")
    public ResponseEntity<List<Whisky>> findByAge(
            @RequestParam(name = "aged", required = false) String aged) {
        if (aged != null) {
            return new ResponseEntity<>(whiskyRepository.findByAge(Integer.parseInt(aged)), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> findByDistillerysNameAndAge(
            @RequestParam(name = "distillery", required = false) String distillery,
            @RequestParam(name = "aged", required = false) String aged)
        {
        if (distillery !=null && aged != null) {
            return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndAge(distillery, Integer.parseInt(aged)), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskyregion")
    public ResponseEntity<List<Whisky>> findByDistilleryRegion(
            @RequestParam(name = "region", required = false) String region)
    {
        if (region !=null) {
            return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }



    @GetMapping(value = "/whisky/{id}")
    public ResponseEntity getWhisky(@PathVariable Long id){

        return new ResponseEntity(whiskyRepository.findById(id), HttpStatus.OK);
    }






}
