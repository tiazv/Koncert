package com.koncert.ris.dao;

import com.koncert.ris.models.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long>{

    @Query(value="SELECT * FROM uporabnik u WHERE u.ime=:ime AND u.priimek=:priimek ", nativeQuery=true)
    List<Uporabnik> vrniDolocenegaUporabnika(String ime, String priimek);

    @Query(value="SELECT * FROM uporabnik u WHERE u.admin =:admin AND u.ime LIKE 'B%' AND u.priimek LIKE 'F%'", nativeQuery=true)
    List<Uporabnik> vrniUporabnikeAdmine(boolean admin);

    @Query(value="SELECT * FROM uporabnik u WHERE u.email='elena.fakin@gmail.com' AND u.admin = 0 AND u.priimek=:priimek ", nativeQuery=true)
    List<Uporabnik> vrniNavadnega(String priimek);
}
