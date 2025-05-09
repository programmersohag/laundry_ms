package com.sohag.laundry_backend.repository;

import com.sohag.laundry_backend.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
}
