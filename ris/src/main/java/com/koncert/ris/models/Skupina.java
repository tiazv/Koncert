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
