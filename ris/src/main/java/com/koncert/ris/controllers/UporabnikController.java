package com.koncert.ris.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.koncert.ris.dao.UporabnikRepository;
import com.koncert.ris.models.Skupina;
import com.koncert.ris.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
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

    // sprint 1
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

        //sprint3
    @GetMapping("/vrniuporabnikasporociloocenaadmin/{st_sporocil}/{st_ocen}/{admin}")
    public Iterable<Uporabnik> vrniUporabnikaSporociloOcenaAdmin(@PathVariable(name = "st_sporocil") int st_sporocil, @PathVariable(name = "st_ocen") int st_ocen, @PathVariable(name = "admin") boolean admin){
        return uporabnikDao.vrniUporabnikaSporociloOcenaAdmin(st_sporocil, st_ocen, admin);
    }

    @GetMapping("/vrniuporabnikavecsporocilalivecocenneime/sporocila/{st_sporocil}/ocene/{st_ocen}/neime/{ime}")
    public Iterable<Uporabnik> vrniUporabnikaVecSporocilAliVecOcenNeIme(@PathVariable(name = "st_sporocil") int st_sporocil, @PathVariable(name = "st_ocen") int st_ocen, @PathVariable(name = "ime") String ime){
        return uporabnikDao.vrniUporabnikaVecSporocilAliVecOcenNeIme(st_sporocil, st_ocen, ime);
    }

    @GetMapping("/vrniuporabnikamanjampakvsajen/sporocila/{st_sporocil}/ocene/{st_ocen}")
    public Iterable<Uporabnik> vrniUporabnikaManjAmpakVsajEn(@PathVariable(name = "st_sporocil") int st_sporocil, @PathVariable(name = "st_ocen") int st_ocen){
        return uporabnikDao.vrniUporabnikaManjAmpakVsajEn(st_sporocil, st_ocen);
    }

    //sprint2
    //registracija
    @PostMapping("/registriraj")
    public boolean registracija(@RequestBody Uporabnik uporabnik) throws NoSuchAlgorithmException {
        List<Uporabnik> upor = uporabnikDao.jeZePrijavljen(uporabnik.getEmail());
        if(upor.size() > 0){
            // uporabnik obstaja
            return false;
        }
        //uporabnik ne obstaja
        String geslo = uporabnik.getGeslo(); //dobim geslo
        System.out.println(geslo);

        //hashiranje
        //1. nacin
        /*
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        byte[] hashek = md.digest(geslo.getBytes(StandardCharsets.UTF_8));
        String hash1 = String.format("%064x", new BigInteger(1, hashek));
        System.out.println(hash1);
         */

        //2. nacin
        MessageDigest md1 = MessageDigest.getInstance("SHA-256");
        md1.update(geslo.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md1.digest();
        String hash = String.format("%064x", new BigInteger(1, digest));


        uporabnik.setGeslo(hash); //spremenim geslo v hash
        //uporabnik.setGeslo(hash1); //spremenim geslo v hash

        //uporabnik.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        uporabnikDao.save(uporabnik);
        System.out.println("Registracija uspešna!");
        return true;
    }

    //prijava
    @PostMapping("/prijavi")
    public boolean prijavi(@RequestBody ObjectNode objectNode) throws NoSuchAlgorithmException {
        System.out.println(objectNode);
        String email = objectNode.get("email").asText();
        String geslo = objectNode.get("geslo").asText();

        //hashiranje
        //1. nacin
        /*
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        byte[] hashek = md.digest(geslo.getBytes(StandardCharsets.UTF_8));
        String hash1 = String.format("%064x", new BigInteger(1, hashek));
        System.out.println(hash1);
         */

        //2. nacin
        MessageDigest md1 = MessageDigest.getInstance("SHA-256");
        md1.update(geslo.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md1.digest();
        String hash = String.format("%064x", new BigInteger(1, digest));

        List<Uporabnik> upor = uporabnikDao.prijavi(email, hash); //hashirano
        //List<Uporabnik> upor1 = uporabnikDao.prijavi(email, hash1); //hashirano
        //List<Uporabnik> upor2 = uporabnikDao.prijavi(email, geslo); //ne hashirano
        if(upor.size() > 0){
            //uporabnik obstaja
            System.out.println("Prijava uspešna!");
            return true;
        }
        //uporabnik ne obstaja
        return false;
    }

} //konec
