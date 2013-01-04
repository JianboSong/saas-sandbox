package com.acxiom.platform.saas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import com.acxiom.platform.saas.db.QUserDTO;
import com.acxiom.platform.saas.db.UserDTO;
import com.acxiom.platform.saas.model.User;

@Repository
public class UserDAOImpl implements UserDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    private QUserDTO qUserDTO = QUserDTO.userDTO;

    @Override
    public List<User> getUsers()
    {
        JPAQuery query = new JPAQuery(entityManager);

        List<User> users = new ArrayList<User>();

        for (UserDTO userDB : query.from(qUserDTO).list(qUserDTO))
        {
            users.add(new User(userDB));
        }

        return users;
    }

    @Override
    public User getUser(String id) {
        JPAQuery query = new JPAQuery(entityManager);

        UserDTO user = query.from(qUserDTO)
                .where(qUserDTO.id.eq(id))
                .uniqueResult(qUserDTO);
        return new User(user);
    }

    @Override
    @Transactional
    public void removeUser(String id)
    {
        JPADeleteClause delete = new JPADeleteClause(entityManager, qUserDTO);
        delete.where(qUserDTO.id.eq(id)).execute();
    }

    @Override
    @Transactional
    public User addUser(User user)
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());

        entityManager.persist(userDTO);

        user.setId(userDTO.getId());
        return user;
    }

    @Override
    @Transactional
    public void updateUser(User user)
    {
        JPAUpdateClause update = new JPAUpdateClause(entityManager, qUserDTO);
        update.set(qUserDTO.name, user.getName()).where(qUserDTO.id.eq(user.getId())).execute();
    }
}
