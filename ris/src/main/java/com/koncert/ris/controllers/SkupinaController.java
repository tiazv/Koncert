package com.koncert.ris.controllers;

import com.koncert.ris.dao.SkupinaRepository;
import com.koncert.ris.models.Koncert;
import com.koncert.ris.models.Skupina;
import com.koncert.ris.models.Sporocilo;
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

    //sprint1
    @GetMapping("/dolocenaskupina")
    public Iterable<Skupina> vrniDolocenoSkupino() {
        return (skupinaDao.vrniDolocenoSkupino());
    }

    @GetMapping("/vecjeskupine")
    public Iterable<Skupina> vrniSkupineVecje() {
        return (skupinaDao.vrniSkupineVecje());
    }

    @GetMapping("/nekaj")
    public Iterable<Skupina> vrniNekaj() {
        return (skupinaDao.vrniNekaj());
    }

    //sprint2
    @GetMapping("/vrniskupinossporocili/{stevilo}/{ime_skupine}")
    public Iterable<Skupina> vrniSkupinoSSporocili(@PathVariable(name = "ime_skupine") String ime_skupine, @PathVariable(name = "stevilo") int stevilo){
        return skupinaDao.vrniSkupinoSSporocili(stevilo, ime_skupine);
    }

    @GetMapping("/vrniskupinossporocili/{stevilo}/{st_udelezencev}")
    public Iterable<Skupina> vrniSkupinoZVecKot(@PathVariable(name = "stevilo") int stevilo, @PathVariable(name = "st_udelezencev") int st_udelezencev){
        return skupinaDao.vrniSkupinoZVecKot(stevilo, st_udelezencev);
    }


    //sprint3

}
