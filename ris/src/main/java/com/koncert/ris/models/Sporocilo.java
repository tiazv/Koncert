package com.koncert.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Sporocilo {
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
    @JoinColumn(name = "skupina_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore

    Uporabnik uporabnik;
    Skupina skupina;
    private String telo;
    private String cas_nastanka;


    public void setTelo(String telo) {
        this.telo = telo;
    }

    /**
     *
     * @param telo
     */
    public void ustvariSporocilo(String telo) {
        // TODO - implement Sporocilo.ustvariSporocilo
        throw new UnsupportedOperationException();
    }
}
