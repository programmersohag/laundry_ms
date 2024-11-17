package com.sohag.laundry_backend.repository;

import com.sohag.laundry_backend.model.Production;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepository extends CrudRepository<Production, Integer> {
}
