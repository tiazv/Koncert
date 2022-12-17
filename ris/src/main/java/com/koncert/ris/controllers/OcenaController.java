package com.koncert.ris.controllers;
import com.koncert.ris.dao.OcenaRepository;
import com.koncert.ris.dao.KoncertRepository;
import com.koncert.ris.dao.UporabnikRepository;
import com.koncert.ris.models.Koncert;
import com.koncert.ris.models.Ocena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ocene")
public class OcenaController {
    @Autowired
    private OcenaRepository ocenaDao;
    @Autowired
    private KoncertRepository koncertDao;
    @Autowired
    private UporabnikRepository uporabnikDao;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/ocene")
    public Iterable<Ocena> vrniVseOcene() {
        return ocenaDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ocena> vrniOceno(@PathVariable(name = "id") Long id){
        return ocenaDao.findById(id);
    }

    /*@PostMapping("/ocene/{id}koncert/{id}uporabnik")
        public Optional<Ocena> dodajOceno(@RequestBody Ocena ocena, @PathVariable(name = "id") Long id){
        return koncertDao.findById(id).map(koncert -> {
            ocena.setKoncert(koncert);
            return ocenaDao.save(ocena);
        }); uporabnikDao.findById(id).map(uporabnik -> {
                    ocena.setUporabnik(uporabnik);
                    return ocenaDao.save(ocena);
        }
        );
    }*/
    @PostMapping("/ocene/{id}koncert/{id2}uporabnik")
    public Optional<Optional<Ocena>> dodajOceno(@RequestBody Ocena ocena, @PathVariable(name = "id") Long id, @PathVariable(name = "id2") Long id2) {
        return koncertDao.findById(id).map(koncert -> {
            ocena.setKoncert(koncert);
            return uporabnikDao.findById(id2).map(uporabnik -> {
                ocena.setUporabnik(uporabnik);
                return ocenaDao.save(ocena);
                    }
            );
        });
    }

    @PutMapping("/spremeni/{id}")
    public Ocena spremeniOceno(@PathVariable(name = "id") Long id, @RequestBody Ocena ocena) {
        if (!ocenaDao.existsById(id))
            return null;

        ocena.setId(id);
        return ocenaDao.save(ocena);
    }

    @DeleteMapping("/zbrisi/{id}")
    public Boolean izbrisiOceno(@PathVariable(name = "id") Long id) {
        if (!ocenaDao.existsById(id))
            return false;
        ocenaDao.deleteById(id);
        return true;
    }


}
