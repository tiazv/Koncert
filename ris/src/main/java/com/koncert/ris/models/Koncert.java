package com.koncert.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;
@Entity
public class Koncert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nastopajoci_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Nastopajoci nastopajoci;

    @OneToMany(mappedBy = "koncert", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Ocena> ocena;

    private String naziv;
    private String datum;
    private String lokacija;
    private String povezava_do_vstopnic;

    public Nastopajoci getNastopajoci() {
        return nastopajoci;
    }

    public void setNastopajoci(Nastopajoci nastopajoci) {
        this.nastopajoci = nastopajoci;
    }

    public Collection<Ocena> getOcena() {
        return ocena;
    }

    public void setOcena(Collection<Ocena> ocena) {
        this.ocena = ocena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public String getPovezava_do_vstopnic() {
        return povezava_do_vstopnic;
    }

    public void setPovezava_do_vstopnic(String povezava_do_vstopnic) {
        this.povezava_do_vstopnic = povezava_do_vstopnic;
    }

    public Koncert() {

        // TODO - implement Koncert.Koncert
        //throw new UnsupportedOperationException();
    }
    /**
     *
     * @param ocena
     */
    public boolean dodajOceno(Ocena ocena) {
        // TODO - implement Koncert.dodajOceno
        throw new UnsupportedOperationException();
    }
}
