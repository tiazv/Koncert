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
    @OneToMany(mappedBy = "koncert", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nastopajoci_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Nastopajoci nastopajoci;
    Collection<Ocena> oceno;
    private String naziv;
    private String datum;
    private String lokacija;
    private Zvrst zvrst;
    private String povezava_do_vstopnic;

    public Koncert() {

        // TODO - implement Koncert.Koncert
        throw new UnsupportedOperationException();
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
