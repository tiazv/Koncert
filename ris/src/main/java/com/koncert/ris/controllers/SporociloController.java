package com.koncert.ris.controllers;
import com.koncert.ris.dao.SkupinaRepository;
import com.koncert.ris.dao.SporociloRepository;
import com.koncert.ris.dao.UporabnikRepository;
import com.koncert.ris.models.Sporocilo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sporocila")
public class SporociloController {
    @Autowired
    private SporociloRepository sporociloDao;
    @Autowired
    private SkupinaRepository skupinaDao;
    @Autowired
    private UporabnikRepository uporabnikDao;

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

    @PostMapping("/skupine/{idjek}/uporabniki/{id}/sporocila")
    public Optional<Optional<Sporocilo>> dodajSporocilo(@RequestBody Sporocilo sporocilo, @PathVariable(name = "idjek") Long idjek, @PathVariable(name = "id") Long id){
        return skupinaDao.findById(idjek).map(skupina -> {
            sporocilo.setSkupina(skupina);
            return uporabnikDao.findById(id).map(uporabnik -> {
                sporocilo.setUporabnik(uporabnik);
                return sporociloDao.save(sporocilo);
            });
        });
    }

    @PostMapping("/skupine/{id}/sporocila")
    public Optional<Sporocilo> dodajSporocila(@RequestBody Sporocilo sporocilo, @PathVariable(name = "id") Long id){
        return skupinaDao.findById(id).map(skupina -> {
            sporocilo.setSkupina(skupina);
            return sporociloDao.save(sporocilo);
        });
    }

    @PostMapping("/uporabniki/{id}/sporocila")
    public Optional<Sporocilo> dodajSporocilca(@RequestBody Sporocilo sporocilo, @PathVariable(name = "id") Long id){
        return uporabnikDao.findById(id).map(uporabnik -> {
            sporocilo.setUporabnik(uporabnik);
            return sporociloDao.save(sporocilo);
        });
    }

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
