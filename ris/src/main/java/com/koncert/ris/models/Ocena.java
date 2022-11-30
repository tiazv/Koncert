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
    @JoinColumn(name = "koncert_id")
    @JoinColumn(name = "uporabnik_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    Uporabnik uporabnik;
    Koncert koncert;
    private int ocena;
    private String komentar;


}
