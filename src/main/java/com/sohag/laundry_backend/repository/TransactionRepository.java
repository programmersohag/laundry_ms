package com.sohag.laundry_backend.repository;

import com.sohag.laundry_backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query("select t from Transaction t where cast(t.dateOfDelivery as date) between ?1 and ?2" )
    List<Transaction> findAllByDateBetween(Date from, Date to);
}
