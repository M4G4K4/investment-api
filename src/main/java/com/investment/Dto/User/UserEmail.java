package com.investment.Dto.User;

public class UserEmail {
    private  String email;

    public UserEmail(String email) {
        this.email = email;
    }

    public UserEmail() {
    }

    public String getEmail() {
        return email;
    }

    public UserEmail setEmail(String email) {
        this.email = email;
        return this;
    }
}
