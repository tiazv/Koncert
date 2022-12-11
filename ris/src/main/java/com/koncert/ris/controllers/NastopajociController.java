package com.koncert.ris.controllers;

import com.koncert.ris.dao.NastopajociRepository;
import com.koncert.ris.models.Koncert;
import com.koncert.ris.models.Nastopajoci;
import com.koncert.ris.models.Zvrst;
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
    public Iterable<Nastopajoci> vrniNastopajoce() {
        return nastopajociDao.findAll();
    }

    @GetMapping("/nastopajoci/{id}")
    public Optional<Nastopajoci> vrniNastopajoce(@PathVariable(name = "id") Long id) {
        return nastopajociDao.findById(id);
    }

    @PostMapping("/dodaj")
    public Nastopajoci dodaj(@RequestBody Nastopajoci nastopajoci) {
        return nastopajociDao.save(nastopajoci);
    }

    @PutMapping("/spremeni/{id}")
    public Nastopajoci spremeniNastopajoce(@PathVariable(name = "id") Long id, @RequestBody Nastopajoci nastopajoci) {
        if (!nastopajociDao.existsById(id))
            return null;

        nastopajoci.setId(id);
        return nastopajociDao.save(nastopajoci);
    }

    @DeleteMapping("/zbrisi/{id}")
    public Boolean izbrisiNastopajoce(@PathVariable(name = "id") Long id) {
        if (!nastopajociDao.existsById(id))
            return false;
        nastopajociDao.deleteById(id);
        return true;
    }

    //kompleksna poizvedba (osnovni del)
    /*@GetMapping("/zvrst/{zvrst}/id/{id}")
    public boolean vrniZvrstNastopajocega(@PathVariable(name = "zvrst") Zvrst zvrst, @PathVariable(name = "id") long id) {
        return (nastopajociDao.vrniZvrstNastopajocega(zvrst, id).size() == 1);
    }*/
    @GetMapping("/vrninastopajoce")
    public Iterable<Nastopajoci> vrniPopNastopajoce() {
        return (nastopajociDao.vrniPopNastopajoce());
    }

     //kompleksna poizvedba (projekt)


}
