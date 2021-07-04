package com.investment.Entity;

import com.investment.Exception.CustomException;
import com.investment.Exception.ErrorCode;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class User extends PanacheEntity {
    private String name;
    private String email;
    private String username;
    private String password;

    //TODO: Add roles table

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }



    public static User findUserByEmail(final String email) throws CustomException {
        return (User) find("email",email).firstResultOptional().orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND) );
    }

    public static User findUserByEmail2(final String email) throws CustomException {
        User user = User.find("email", email).firstResult();
        if(user == null){
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
        return user;
    }

}
