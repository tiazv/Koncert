package com.koncert.ris.controllers;

import com.koncert.ris.dao.UporabnikRepository;
import com.koncert.ris.models.Skupina;
import com.koncert.ris.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/uporabniki")
public class UporabnikController {
    @Autowired
    private UporabnikRepository uporabnikDao;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/uporabniki")
    public Iterable<Uporabnik> vrniVseUporabnike() {
        return uporabnikDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Uporabnik> vrniUporabnika(@PathVariable(name = "id") Long id){
        return uporabnikDao.findById(id);
    }

    @PostMapping("/dodaj")
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik uporabnik){
        return uporabnikDao.save(uporabnik);
    }

    @PutMapping("/spremeni/{id}")
    public Uporabnik spremeniUporabnika(@PathVariable(name="id") Long id, @RequestBody Uporabnik uporabnik) {
        if(!uporabnikDao.existsById(id))
            return null;
        uporabnik.setId(id);
        return uporabnikDao.save(uporabnik);
    }

    @DeleteMapping("/zbrisi/{id}")
    public Boolean izbrisiUporabnika(@PathVariable(name="id") Long id) {
        if(!uporabnikDao.existsById(id))
            return false;
        uporabnikDao.deleteById(id);
        return true;
    }


    // kompleksna poizvedba (osnovni del)
    // vrne uporabnika z dolločenih imenom in priimkom
    @GetMapping("/{ime}/{priimek}")
    public Iterable<Uporabnik> vrniDolocenegaUporabnika(@PathVariable(name = "ime") String ime, @PathVariable(name = "priimek") String priimek) {
        return uporabnikDao.vrniDolocenegaUporabnika(ime, priimek);
    }

    @GetMapping("/vrniuporabnikeadmine/{admin}")
    public Iterable<Uporabnik> vrniUporabnikeAdmine(@PathVariable(name = "admin") boolean admin) {
        return (uporabnikDao.vrniUporabnikeAdmine(admin));
    }

    @GetMapping("/vrninavadnega/{priimek}")
        public Iterable<Uporabnik> vrniNavadnega(@PathVariable(name = "priimek") String priimek) {
            return uporabnikDao.vrniNavadnega(priimek);
        }

}
