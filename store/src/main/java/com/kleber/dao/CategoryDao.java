package com.kleber.dao;

import com.kleber.model.Category;
import javax.persistence.EntityManager;

public class CategoryDao {

    private EntityManager em;

    public CategoryDao(EntityManager em){
        this.em = em;
    }
    public void  add(Category c){
        this.em.persist(c);
    }
    public void update(Category c){
        this.em.merge(c);
    }
    public void remove(Category c){
        c = em.merge(c);
        this.em.remove(c);
    }
}
