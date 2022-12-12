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

        @Query(value="SELECT id, count(koncert) AS 'st' FROM nastopajoci n WHERE n.st = 1", nativeQuery=true)
        List<Nastopajoci> vrniKoncerteDva();
}
