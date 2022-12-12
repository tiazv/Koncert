package com.koncert.ris.controllers;
import com.koncert.ris.dao.SporociloRepository;
import com.koncert.ris.models.Koncert;
import com.koncert.ris.models.Skupina;
import com.koncert.ris.models.Sporocilo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sporocila")
public class SporociloController {
    @Autowired
    private SporociloRepository sporociloDao;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/sporocila")
    public Iterable<Sporocilo> vrniVsaSporocila() {
        return sporociloDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Sporocilo> vrniSporocilo(@PathVariable(name = "id") Long id){
        return sporociloDao.findById(id);
    }
/*
    @PostMapping("/nastopajoci/{id}koncerti")
    public Optional<Koncert> dodajKoncerte(@RequestBody Koncert koncert, @PathVariable(name = "id") Long id){
        return nastopajociDao.findById(id).map(nastopajoci -> {
            koncert.setNastopajoci(nastopajoci);
            return koncertDao.save(koncert);
        });
    }
*/

    @PutMapping("/spremeni/{id}")
    public Sporocilo spremeniSporocilo(@PathVariable(name="id") Long id, @RequestBody Sporocilo sporocilo) {
        if(!sporociloDao.existsById(id))
            return null;
        sporocilo.setId(id);
        return sporociloDao.save(sporocilo);
    }

    @DeleteMapping("/zbrisi/{id}")
    public Boolean izbrisiSporocilo(@PathVariable(name="id") Long id) {
        if(!sporociloDao.existsById(id))
            return false;
        sporociloDao.deleteById(id);
        return true;
    }



}
