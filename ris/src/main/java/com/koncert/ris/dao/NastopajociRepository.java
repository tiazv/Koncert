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

        /*@Query(value = "SELECT * FROM nastopajoci n WHERE zvrst=POP AND naziv LIKE "A%" AND , nativeQuery = true)
        List<Nastopajoci> vrniZvrstNastopajocega(Zvrst zvrst, long id);*/
}
