package com.investment.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock extends PanacheEntity {
    public String ticker;
    public String name;
    public String exchange;

}
