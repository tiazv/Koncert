package com.koncert.ris.controllers;

import com.koncert.ris.dao.KoncertRepository;
import com.koncert.ris.dao.NastopajociRepository;
import com.koncert.ris.models.Koncert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RestController
@RequestMapping("/koncerti")

public class KoncertController {
    @Autowired
    private KoncertRepository koncertDao;
    @Autowired
    private NastopajociRepository nastopajociDao;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/koncerti")
    public Iterable<Koncert> vrniKoncerte() {
        return koncertDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Koncert> vrniKoncerte(@PathVariable(name = "id") Long id){
        return koncertDao.findById(id);
    }
/*
    @PostMapping("/dodajkoncerte")
    public Koncert dodajKoncerte(@RequestBody Koncert koncert){
        return koncertDao.save(koncert);
    }
    */

    @PostMapping("/dodaj")
    public Koncert dodajKoncert(@RequestBody Koncert koncert){
        return koncertDao.save(koncert);
    }

    @PostMapping("/nastopajoci/{id}koncerti")
        public Optional<Koncert> dodajKoncerte(@RequestBody Koncert koncert, @PathVariable(name = "id") Long id){
        return nastopajociDao.findById(id).map(nastopajoci -> {
            koncert.setNastopajoci(nastopajoci);
            return koncertDao.save(koncert);
        });
    }

}