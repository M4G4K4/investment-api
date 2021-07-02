package com.investment.Dto.User;

import java.sql.Timestamp;

public class UserRead {
    private long id;
    private String name;
    private String email;
    private String username;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public long getId() {
        return id;
    }

    public UserRead setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserRead setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRead setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRead setUsername(String username) {
        this.username = username;
        return this;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public UserRead setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public UserRead setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
