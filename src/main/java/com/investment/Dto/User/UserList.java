package com.investment.Dto.User;

import java.util.List;

public class UserList {
    private List<UserRead> users;

    public List<UserRead> getUsers() {
        return users;
    }

    public UserList setUsers(List<UserRead> users) {
        this.users = users;
        return this;
    }
}
