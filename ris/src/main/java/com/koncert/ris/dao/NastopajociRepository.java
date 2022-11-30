package com.koncert.ris.dao;

import com.koncert.ris.models.Nastopajoci;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NastopajociRepository extends CrudRepository<Nastopajoci, Long> {
}
