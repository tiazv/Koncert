package com.koncert.ris.controllers;

import com.koncert.ris.dao.NastopajociRepository;
import com.koncert.ris.models.Koncert;
import com.koncert.ris.models.Nastopajoci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/nastopajoci")
public class NastopajociController {
    @Autowired
    private NastopajociRepository nastopajociDao;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/nastopajoci")
    public Iterable<Nastopajoci> vrniNastopajoce(){
        return nastopajociDao.findAll();
    }

    @GetMapping("/nastopajoci/{id}")
    public Optional<Nastopajoci> vrniNastopajoce(@PathVariable(name = "id") Long id){
        return nastopajociDao.findById(id);
    }

    @PostMapping
    public Nastopajoci dodajNastopajoce(@RequestBody Nastopajoci nastopajoci){
        return nastopajociDao.save(nastopajoci);
    }
}
