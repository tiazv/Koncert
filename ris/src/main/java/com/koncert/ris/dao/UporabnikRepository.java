package com.koncert.ris.dao;

import com.koncert.ris.models.Skupina;
import com.koncert.ris.models.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long>{

    //sprint 1
    @Query(value="SELECT * FROM uporabnik u WHERE u.ime=:ime AND u.priimek=:priimek ", nativeQuery=true)
    List<Uporabnik> vrniDolocenegaUporabnika(String ime, String priimek);

    @Query(value="SELECT * FROM uporabnik u WHERE u.admin =:admin AND u.ime LIKE 'B%' AND u.priimek LIKE 'F%'", nativeQuery=true)
    List<Uporabnik> vrniUporabnikeAdmine(boolean admin);

    @Query(value="SELECT * FROM uporabnik u WHERE u.email='elena.fakin@gmail.com' AND u.admin = 0 AND u.priimek=:priimek ", nativeQuery=true)
    List<Uporabnik> vrniNavadnega(String priimek);

    //sprint 3
    //x sporocil in y ocen in admin true/false
    @Query("SELECT u FROM Uporabnik u WHERE size(u.Sporocilo)=:st_sporocil AND size(u.ocena)=:st_ocen AND u.admin=:admin")
    List<Uporabnik> vrniUporabnikaSporociloOcenaAdmin(int st_sporocil, int st_ocen, boolean admin);

    //vsaj x sporocil ali vsaj y ocen in ni ime
    @Query("SELECT u FROM Uporabnik u WHERE size(u.Sporocilo)>:st_sporocil OR size(u.ocena)>:st_ocen AND NOT u.ime=:ime")
    List<Uporabnik> vrniUporabnikaVecSporocilAliVecOcenNeIme(int st_sporocil, int st_ocen, String ime);

    //manj kot x sporocil in y ocen ampak vec kot nic
    @Query("SELECT u FROM Uporabnik u WHERE size(u.Sporocilo)<:st_sporocil AND size(u.Sporocilo)>0 AND size(u.ocena)<:st_ocen AND size(u.ocena)>0")
    List<Uporabnik> vrniUporabnikaManjAmpakVsajEn(int st_sporocil, int st_ocen);


    //sprint2
    // registracija
    @Query(value="SELECT * FROM uporabnik u WHERE u.email = :email ", nativeQuery=true)
    List<Uporabnik> jeZePrijavljen(String email);

    // prijava
    @Query(value="SELECT * FROM uporabnik WHERE email = :email AND geslo = :geslo", nativeQuery=true)
    List<Uporabnik> prijavi(String email, String geslo);
}
