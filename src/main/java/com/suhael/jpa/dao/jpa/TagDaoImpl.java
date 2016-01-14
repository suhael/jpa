package com.suhael.jpa.dao.jpa;

import com.suhael.jpa.model.Tag;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TagDaoImpl extends AbstractJPA<Tag> implements TagDao {

    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public TagDaoImpl() {
        super(Tag.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Tag> getTags() {
        return super.findAll();
    }
}
