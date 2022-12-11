package com.koncert.ris.dao;

import com.koncert.ris.models.Skupina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkupinaRepository extends CrudRepository<Skupina, Long> {

    @Query(value="SELECT * FROM skupina s WHERE s.ime_skupine='Obozevalci' AND s.datum_kreacije='2022-11-26'", nativeQuery=true)
    List<Skupina> vrniDolocenoSkupino();


    @Query(value="SELECT * FROM skupina s WHERE s.st_udelezencev>=3 AND s.st_udelezencev>=6 AND s.ime_skupine LIKE 'A%'", nativeQuery=true)
    List<Skupina> vrniSkupineVecje();


@Query(value="SELECT * FROM skupina s WHERE s.datum_kreacije LIKE '2021%' AND s.st_udelezencev>5", nativeQuery=true)
    List<Skupina> vrniNekaj();

}
