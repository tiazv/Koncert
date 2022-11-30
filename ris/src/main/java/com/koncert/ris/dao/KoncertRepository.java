package com.koncert.ris.dao;

import com.koncert.ris.models.Koncert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface KoncertRepository extends CrudRepository <Koncert, Long> {

}
