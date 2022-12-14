package com.koncert.ris.dao;

import com.koncert.ris.models.Nastopajoci;
import com.koncert.ris.models.Zvrst;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NastopajociRepository extends CrudRepository<Nastopajoci, Long> {

        /*@Query(value = "SELECT * FROM nastopajoci n WHERE n.id=:id AND (n.zvrst=POP OR n.zvrst=ROCK)", nativeQuery = true)
        List<Nastopajoci> vrniZvrstNastopajocega(Zvrst zvrst, long id);*/
        @Query(value="SELECT * FROM nastopajoci n WHERE zvrst='POP' AND naziv LIKE 'A%'", nativeQuery=true)
        List<Nastopajoci> vrniPopNastopajoce();

        //artisti ki se zacnejo na C koncajo na y in niso skupina
        //izpis posamezno
        @Query(value="SELECT * FROM nastopajoci n WHERE n.naziv=:naziv AND naziv LIKE '%Y' AND naziv LIKE 'C%' AND skupina=false", nativeQuery=true)
        List<Nastopajoci> vrniNastopajoceNaziv(String naziv);

        //izpis vseh
        @Query(value="SELECT * FROM nastopajoci n WHERE naziv LIKE '%Y' AND naziv LIKE 'C%' AND skupina=false", nativeQuery=true)
        List<Nastopajoci> vrniRockNastopajoce();

        //artist ki zacne na m ina manj ko 3 albume in je skupina
        //izpis posamezno
        @Query(value="SELECT * FROM nastopajoci n WHERE n.skupina=:skupina AND n.st_album<=3 AND naziv LIKE 'M%' AND skupina=true", nativeQuery=true)
        List<Nastopajoci> vrniNastopajoceSkupina(boolean skupina);

        //izpis vseh
        @Query(value="SELECT * FROM nastopajoci n WHERE n.st_album<=3 AND naziv LIKE 'M%' AND skupina=true", nativeQuery=true)
        List<Nastopajoci> vrniSkupinoNastopajoce();
        /*@Query(value = "SELECT * FROM nastopajoci n WHERE zvrst=POP AND naziv LIKE "A%" AND , nativeQuery = true)
        List<Nastopajoci> vrniZvrstNastopajocega(Zvrst zvrst, long id);*/

        //izpis id-ja in naziva koncerta ter naziv nastopajocega glede na njegov id
        /*@Query(value="SELECT n FROM nastopajoci n where size(n.koncert) > 1", nativeQuery=true)
        List<Nastopajoci> vrniKoncerteDva();*/

        /*@Query(value="SELECT k.id, k.naziv, n.naziv  FROM koncert k INNER JOIN nastopajoci n ON k.nastopajoci_id = n.id WHERE k.nastopajoci_id = 2", nativeQuery=true)
        List<Nastopajoci> vrniKoncerteDve();*/
        @Query("SELECT n FROM Nastopajoci n WHERE size(n.koncert) >=:stevilo")
        List<Nastopajoci> vrniKoncerteDva(int stevilo);

        @Query("SELECT n FROM Nastopajoci n WHERE size(n.koncert) > 1 AND n.skupina=:skupina")
        List<Nastopajoci> vrniKoncerteSkupine(boolean skupina);


        //SELECT id, count(koncert.id) AS 'st' FROM nastopajoci n WHERE n.st = 1
        //SELECT k.id, k.naziv, n.naziv  FROM koncert k INNER JOIN nastopajoci n ON k.nastopajoci_id = n.id WHERE k.nastopajoci_id = 2
        //SELECT COUNT(k.id) AS st_koncertov, n.naziv FROM koncert k  INNER JOIN nastopajoci n ON k.nastopajoci_id = n.id WHERE k.nastopajoci_id = 2

        //poizvedbe (sprint 3)
        /*@Query("SELECT n FROM Nastopajoci n INNER JOIN Koncert k WHERE n.skupina=:skupina AND k.id=:id")
        List<Nastopajoci> vrniOcenoKoncerta(boolean skupina, Long id);*/

        /*@Query("SELECT n FROM Nastopajoci n INNER JOIN Koncert k WHERE size(k.ocena) =:stevilo")
        List<Nastopajoci> vrniKoncert(int stevilo);*/

        @Query("SELECT n FROM Nastopajoci n INNER JOIN Koncert k WHERE size(n.koncert) >=:stevilo AND size(k.ocena) =:stevilo2 AND n.skupina=:skupina")
        List<Nastopajoci> vrniKoncertOceno(int stevilo, int stevilo2, boolean skupina);

        @Query(value = "SELECT * FROM nastopajoci n INNER JOIN koncert k ON k.nastopajoci_id = n.id INNER JOIN ocena o ON o.koncert_id = k.id WHERE o.ocena=:ocena", nativeQuery = true)
        List vrniOceno(int ocena);

        @Query(value = "SELECT * FROM nastopajoci n INNER JOIN koncert k ON k.nastopajoci_id = n.id INNER JOIN ocena o ON o.koncert_id = k.id WHERE o.ocena>=:stevilo AND k.lokacija=:lokacija", nativeQuery = true)
        List vrniOcenoLokacija(int stevilo, String lokacija);
        //@Query(value = "SELECT * FROM taksi t INNER JOIN taksi_sluzba ts ON t.sluzba_id=ts.id INNER JOIN taksist tak ON tak.sluzba_id=ts.id", nativeQuery = true)

}
