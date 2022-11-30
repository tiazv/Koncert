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
    public String ime;
    private String priimek;
    private String email;
    private String geslo;
    private boolean admin;

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

