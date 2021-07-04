package com.investment.Dto.User;

public class UserLoginResponse {
    private long id;

    private String name;

    private String email;

    private String username;

    private String token;

    public UserLoginResponse() {
    }



    public long getId() {
        return id;
    }

    public UserLoginResponse setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserLoginResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserLoginResponse setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserLoginResponse setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UserLoginResponse setToken(String token) {
        this.token = token;
        return this;
    }
}
