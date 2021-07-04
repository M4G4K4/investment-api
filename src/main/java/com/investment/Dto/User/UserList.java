package com.investment.Dto.User;

import java.util.List;

public class UserList {
    private List<UserResponse> users;

    public List<UserResponse> getUsers() {
        return users;
    }

    public UserList setUsers(List<UserResponse> users) {
        this.users = users;
        return this;
    }
}
