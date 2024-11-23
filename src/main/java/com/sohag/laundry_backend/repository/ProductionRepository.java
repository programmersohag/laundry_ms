package com.sohag.laundry_backend.repository;

import com.sohag.laundry_backend.dto.ProductionDto;
import com.sohag.laundry_backend.model.Production;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionRepository extends CrudRepository<Production, Long> {

    @Query("select new com.sohag.laundry_backend.dto.ProductionDto(r.id, r.employeeId, r.details, r.total, r.dateOfIssue) from Production r order by r.employeeId")
    List<ProductionDto> findAllExpenditure();
}
