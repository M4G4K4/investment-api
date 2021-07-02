package com.investment.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends PanacheEntity {
    public String name;
    public String email;
    public String username;
    public String password;
}
