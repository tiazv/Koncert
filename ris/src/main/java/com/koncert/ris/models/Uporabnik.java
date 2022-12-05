package com.koncert.ris.models;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Uporabnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    Collection<Ocena> oceno;
    Collection<Sporocilo> Sporocilo;
    private String ime;
    private String priimek;
    private String email;
    private String geslo;
    private boolean admin;

    public Collection<Ocena> getOceno() {
        return oceno;
    }

    public void setOceno(Collection<Ocena> oceno) {
        this.oceno = oceno;
    }

    public Collection<com.koncert.ris.models.Sporocilo> getSporocilo() {
        return Sporocilo;
    }

    public void setSporocilo(Collection<com.koncert.ris.models.Sporocilo> sporocilo) {
        Sporocilo = sporocilo;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGeslo() {
        return geslo;
    }

    public void setGeslo(String geslo) {
        this.geslo = geslo;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Uporabnik() {
        // TODO - implement Uporabnik.Uporabnik
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param ocena
     */
    public void oceniKoncert(Ocena ocena) {
        // TODO - implement Uporabnik.oceniKoncert
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param email
     * @param geslo
     */
    public boolean prijava(String email, String geslo) {
        // TODO - implement Uporabnik.prijava
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param email
     * @param geslo
     * @param gesloPotrdi
     */
    public boolean registracija(String email, String geslo, String gesloPotrdi) {
        // TODO - implement Uporabnik.registracija
        throw new UnsupportedOperationException();
    }

}

