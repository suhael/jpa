package com.suhael.jpa.dao.jpa;

import com.suhael.jpa.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserDaoImpl extends AbstractJPA<User> implements UserDao {

    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public UserDaoImpl(){
        super(User.class);
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    public List<User> getUsers(){
        return super.findAll();
    }
}
