package com.koncert.ris.dao;

import com.koncert.ris.models.Skupina;
import com.koncert.ris.models.Sporocilo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkupinaRepository extends CrudRepository<Skupina, Long> {

    //sprint1
    @Query(value="SELECT * FROM skupina s WHERE s.ime_skupine='Obozevalci' AND s.datum_kreacije='2022-11-26'", nativeQuery=true)
    List<Skupina> vrniDolocenoSkupino();

    @Query(value="SELECT * FROM skupina s WHERE s.st_udelezencev>=3 AND s.st_udelezencev<=6 AND s.ime_skupine LIKE 'A%'", nativeQuery=true)
    List<Skupina> vrniSkupineVecje();

    @Query(value="SELECT * FROM skupina s WHERE s.datum_kreacije LIKE '2021%' AND s.st_udelezencev<=5", nativeQuery=true)
    List<Skupina> vrniNekaj();

    //sprint 2
    @Query("SELECT s FROM Skupina s WHERE size(s.sporocilo)=:stevilo AND s.ime_skupine=:ime_skupine")
    List<Skupina> vrniSkupinoSSporocili(int stevilo, String ime_skupine);

    @Query("SELECT s FROM Skupina s WHERE size(s.sporocilo)>:stevilo AND s.st_udelezencev>:st_udelezencev")
    List<Skupina> vrniSkupinoZVecKot(int stevilo, int st_udelezencev);

    /*
    @Query(value = "SELECT sp.id, sp.telo FROM skupina sk INNER JOIN sporocilo sp ON sk.id = sp.skupina_id WHERE skupina_id =:skupina_id GROUP BY sp.id;", nativeQuery = true)
    List<Sporocilo> vrniVsaSporocilaIzDoloceneSkupine(int skupina_id);

    @Query(value = "SELECT sp.id, sp.telo FROM skupina sk INNER JOIN sporocilo sp ON sk.id = sp.skupina_id WHERE skupina_id =2 GROUP BY sp.id;", nativeQuery = true)
    List<Sporocilo> vracam();

    @Query(value = "SELECT COUNT(sp.id) FROM skupina sk INNER JOIN sporocilo sp ON sk.id = sp.skupina_id  WHERE skupina_id = 3;", nativeQuery = true)
    List<Sporocilo> vrzemo();

    @Query(value = "SELECT s FROM sporocilo s", nativeQuery = true)
    List<Sporocilo> vrniHihi(int st_sporocil);
     */

}
