package com.koncert.ris.dao;

import com.koncert.ris.models.Koncert;
import com.koncert.ris.models.Nastopajoci;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface KoncertRepository extends CrudRepository <Koncert, Long> {
    /*@Query(value="SELECT COUNT(k.id) AS st_koncertov, n.naziv FROM koncert k INNER JOIN nastopajoci n ON k.nastopajoci_id = n.id WHERE k.nastopajoci_id = 2", nativeQuery=true)
    List<Koncert> vrniKoncerteDva();*/

}
