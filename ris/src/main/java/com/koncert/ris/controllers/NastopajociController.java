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
    @GetMapping("/vrninastopajocepop")
    public Iterable<Nastopajoci> vrniPopNastopajoce() {
        return (nastopajociDao.vrniPopNastopajoce());
    }


     //kompleksna poizvedba (projekt)
     //artist zacne na c konca na y in ni skupina
     @GetMapping("/{naziv}")
     public Iterable<Nastopajoci> vrniNastopajoceNaziv(@PathVariable(name = "naziv") String naziv) {
         return nastopajociDao.vrniNastopajoceNaziv(naziv);
     }
     @GetMapping("/vrninastopajocerock")
     public Iterable<Nastopajoci> vrniRockNastopajoce() {
         return (nastopajociDao.vrniRockNastopajoce());
     }

     //artist ki zacne na m ina manj ko 3 albume in je skupina
     @GetMapping("/skupina/{skupina}")
     public Iterable<Nastopajoci> vrniNastopajoceSkupina(@PathVariable(name = "skupina") boolean skupina) {
         return nastopajociDao.vrniNastopajoceSkupina(skupina);
     }
    @GetMapping("/vrninastopajoceskupina")
    public Iterable<Nastopajoci> vrniSkupinoNastopajoce() {
        return (nastopajociDao.vrniSkupinoNastopajoce());
    }

    //kompleksna poizvedba (osnovni del 2)
    @GetMapping("/vrnikoncertedva")
    public Iterable<Nastopajoci> vrniKoncerteDva() {return (nastopajociDao.vrniKoncerteDva());}
}
