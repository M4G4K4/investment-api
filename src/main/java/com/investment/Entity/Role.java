package com.investment.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends PanacheEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
