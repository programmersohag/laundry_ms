package com.sohag.laundry_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "user_id")
    private String id;
    private String name;
    private String username;
    private String password;
    private String level;
}
