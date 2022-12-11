package com.koncert.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
public class Ocena {
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

    @JoinColumn(name = "uporabnik_id")

    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    Uporabnik uporabnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "koncert_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    Koncert koncert;

    private int ocena;
    private String komentar;

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }

    public Koncert getKoncert() {
        return koncert;
    }

    public void setKoncert(Koncert koncert) {
        this.koncert = koncert;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
}
