package com.koncert.ris.dao;

import com.koncert.ris.models.Ocena;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OcenaRepository extends CrudRepository<Ocena, Long>{

}
