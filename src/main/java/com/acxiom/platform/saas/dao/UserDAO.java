package com.acxiom.platform.saas.dao;

import java.util.List;

import com.acxiom.platform.saas.model.User;

public interface UserDAO
{
    List<User> getUsers();

    User getUser(String id);

    void removeUser(String id);

    User addUser(User user);

    void updateUser(User user);
}