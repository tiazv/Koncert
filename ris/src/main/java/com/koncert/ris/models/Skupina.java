package com.koncert.ris.models;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Skupina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "skupina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Sporocilo> sporocilo;

    private String datum_kreacije;
    private String ime_skupine;

    public Collection<Sporocilo> getSporocilo() {
        return sporocilo;
    }

    public void setSporocilo(Collection<Sporocilo> sporocilo) {
        this.sporocilo = sporocilo;
    }

    public String getDatum_kreacije() {
        return datum_kreacije;
    }

    public void setDatum_kreacije(String datum_kreacije) {
        this.datum_kreacije = datum_kreacije;
    }

    public String getIme_skupine() {
        return ime_skupine;
    }

    public void setIme_skupine(String ime_skupine) {
        this.ime_skupine = ime_skupine;
    }

    /**
     *
     * @param uporabnik
     */
    public boolean novUporabnik(Uporabnik uporabnik) {
        // TODO - implement Skupina.novUporabnik
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param sporocilo
     */
    public boolean dodajSporocilo(Sporocilo sporocilo) {
        // TODO - implement Skupina.dodajSporocilo
        throw new UnsupportedOperationException();
    }
}
