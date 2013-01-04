package com.acxiom.platform.saas.services;

import java.util.HashMap;
import java.util.List;

import com.acxiom.platform.saas.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acxiom.platform.saas.model.User;

@Service
public class UsersService
{
    @Autowired
    private UserDAO userDAO;
    
    public List<User> getUsers()
    {
        // ToDo: retrieve data from metadata service
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("aaa", "ccc");
        map.put("bbb", "ddd");

        List<User> users = userDAO.getUsers();
        for(User user : users) {
            user.setMetadata(map);
        }

        return users;
    }

    public User getUser(String id)
    {
        return userDAO.getUser(id);
    }

    public void removeUser(String id)
    {
        // ToDo: remove metadata from metadata service
        userDAO.removeUser(id);
    }

    public User addUser(User user)
    {
        // ToDo: create metadata into metadata service
        return userDAO.addUser(user);
    }

    public void updateUser(User user)
    {
        // ToDo: update metadata from metadata service
        userDAO.updateUser(user);
    }
}
