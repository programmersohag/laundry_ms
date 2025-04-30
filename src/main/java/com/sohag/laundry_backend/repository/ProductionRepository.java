package com.sohag.laundry_backend.repository;

import com.sohag.laundry_backend.dto.ProductionDto;
import com.sohag.laundry_backend.model.Production;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductionRepository extends CrudRepository<Production, Long> {

    @Query("select new com.sohag.laundry_backend.dto.ProductionDto(p.id, p.employeeId, p.details, p.total, p.dateOfIssue) from Production p order by p.employeeId")
    List<ProductionDto> findAllExpenditure();

    @Query("select new com.sohag.laundry_backend.dto.ProductionDto(p.id, p.employeeId, p.details, p.total, p.dateOfIssue) from Production p where cast(p.dateOfIssue as date) between ?1 and ?2" )
    List<ProductionDto> findAllByDateBetween(Date from, Date to);
}
