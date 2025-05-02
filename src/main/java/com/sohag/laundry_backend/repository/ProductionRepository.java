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

    @Query("select new com.sohag.laundry_backend.dto.ProductionDto(p.id, p.employee.id, p.employee.name, p.details, p.total, p.dateOfIssue) from Production p left join p.employee order by p.employee.id")
    List<ProductionDto> findAllExpenditure();

    @Query("select new com.sohag.laundry_backend.dto.ProductionDto(p.id, p.employee.id, p.employee.name, p.details, p.total, p.dateOfIssue) from Production p left join p.employee where cast(p.dateOfIssue as date) between ?1 and ?2" )
    List<ProductionDto> findAllByDateBetween(Date from, Date to);

    @Query("select sum(p.total) from Production p where cast(p.dateOfIssue as date) between ?1 and ?2")
    Double findTotalExpenseThisYear(Date from, Date to);
}
