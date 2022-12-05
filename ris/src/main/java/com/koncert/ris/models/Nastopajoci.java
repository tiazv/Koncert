package com.koncert.ris.models;

import jakarta.persistence.*;
import java.util.*;
@Entity
public class Nastopajoci {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }

    @OneToMany(mappedBy = "nastopajoci", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Koncert> koncert;
    private String naziv;
    private Zvrst zvrst;

    public Collection<Koncert> getKoncert() {
        return koncert;
    }

    public void setKoncert(Collection<Koncert> koncert) {
        this.koncert = koncert;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Nastopajoci() {
        // TODO - implement Nastopajoci.Nastopajoci
        throw new UnsupportedOperationException();
    }
}
