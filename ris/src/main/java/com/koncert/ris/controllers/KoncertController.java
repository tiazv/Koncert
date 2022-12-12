package com.koncert.ris.controllers;

import com.koncert.ris.dao.KoncertRepository;
import com.koncert.ris.dao.NastopajociRepository;
import com.koncert.ris.models.Koncert;
import com.koncert.ris.models.Nastopajoci;
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

    @PostMapping("/nastopajoci/{id}koncerti")
        public Optional<Koncert> dodajKoncerte(@RequestBody Koncert koncert, @PathVariable(name = "id") Long id){
        return nastopajociDao.findById(id).map(nastopajoci -> {
            koncert.setNastopajoci(nastopajoci);
            return koncertDao.save(koncert);
        });
    }

    @PutMapping("/spremeni/{id}")
    public Koncert spremeniKoncerte(@PathVariable(name = "id") Long id, @RequestBody Koncert koncert) {
        if (!koncertDao.existsById(id))
            return null;

        koncert.setId(id);
        return koncertDao.save(koncert);
    }

    @DeleteMapping("/zbrisi/{id}")
    public Boolean izbrisiKoncerte(@PathVariable(name = "id") Long id) {
        if (!koncertDao.existsById(id))
            return false;
        koncertDao.deleteById(id);
        return true;
    }



}