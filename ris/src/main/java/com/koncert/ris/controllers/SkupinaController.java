package com.koncert.ris.controllers;

import com.koncert.ris.dao.SkupinaRepository;
import com.koncert.ris.models.Koncert;
import com.koncert.ris.models.Skupina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/skupine")
public class SkupinaController {
    @Autowired
    private SkupinaRepository skupinaDao;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }


    @GetMapping("/skupine")
    public Iterable<Skupina> vrnivseskupine() {
        return skupinaDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Skupina> vrniskupino(@PathVariable(name = "id") Long id){
        return skupinaDao.findById(id);
    }

    @PostMapping("/dodaj")
    public Skupina dodajSkupino(@RequestBody Skupina skupina){
        return skupinaDao.save(skupina);
    }

    @PutMapping("/spremeni/{id}")
    public Skupina spremeniskupino(@PathVariable(name="id") Long id, @RequestBody Skupina skupina) {
        if(!skupinaDao.existsById(id))
            return null;
        skupina.setId(id);
        return skupinaDao.save(skupina);
    }

    @DeleteMapping("/zbrisi/{id}")
    public Boolean izbrisiSkupino(@PathVariable(name="id") Long id) {
        if(!skupinaDao.existsById(id))
            return false;
        skupinaDao.deleteById(id);
        return true;
    }

    //osnovni del kompleksna z 2
    @GetMapping("/dolocenaskupina")
    public Iterable<Skupina> vrniDolocenoSkupino() {
        return (skupinaDao.vrniDolocenoSkupino());
    }

//projektni del 1. kompleksna s tremi
    @GetMapping("/vecjeskupine")
    public Iterable<Skupina> vrniSkupineVecje() {
        return (skupinaDao.vrniSkupineVecje());
    }

    //projektni del 2. kompleksna s 3
    @GetMapping("/nekaj")
    public Iterable<Skupina> vrniNekaj() {
        return (skupinaDao.vrniNekaj());
    }

}
