package com.suhael.jpa.dao.jpa;

import com.suhael.jpa.model.Credential;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CredentialDaoImpl extends AbstractJPA<Credential> implements CredentialDao {

    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public CredentialDaoImpl(){
        super(Credential.class);
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Credential> getCredentials(){
        return super.findAll();
    }
}
