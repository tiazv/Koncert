package com.koncert.ris.dao;

import com.koncert.ris.models.Sporocilo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SporociloRepository extends CrudRepository<Sporocilo, Long> {
}
