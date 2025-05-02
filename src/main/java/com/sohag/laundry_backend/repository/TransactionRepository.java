package com.sohag.laundry_backend.repository;

import com.sohag.laundry_backend.dto.OrderDto;
import com.sohag.laundry_backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query("select new com.sohag.laundry_backend.dto.OrderDto(t.id, t.employee.id, t.employee.name, t.customer.id, t.customer.name, t.weight, t.total, t.dateOfOrder, t.dateOfDelivery) from Transaction t where cast(t.dateOfOrder as date) between ?1 and ?2")
    List<OrderDto> findAllByDateBetween(Date from, Date to);

    @Query("select new com.sohag.laundry_backend.dto.OrderDto(t.id, t.employee.id, t.employee.name, t.customer.id, t.customer.name, t.weight, t.total, t.dateOfOrder, t.dateOfDelivery) from Transaction t left join t.customer left join t.employee where t.dateOfDelivery is null")
    List<OrderDto> findAllOrder();

    @Query("select new com.sohag.laundry_backend.dto.OrderDto(t.id, t.employee.id, t.employee.name, t.customer.id, t.customer.name, t.weight, t.total, t.dateOfOrder, t.dateOfDelivery) from Transaction t left join t.customer left join t.employee where t.id = ?1")
    Optional<OrderDto> findOneOrder(String transactionId);

    Long countByDateOfDeliveryIsNull();
    Long countByDateOfDeliveryIsNotNull();
    @Query("select sum(t.total) from Transaction t where cast(t.dateOfOrder as date) between ?1 and ?2")
    Double findTotalTrxThisYear(Date from, Date to);
}
