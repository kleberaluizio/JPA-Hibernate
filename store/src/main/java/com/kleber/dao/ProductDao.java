package com.kleber.dao;

import com.kleber.model.Product;

import javax.persistence.EntityManager;

public class ProductDao {
    private EntityManager em;


    public ProductDao(EntityManager em) {
        this.em = em;
    }

    public Product findById(Long id){
        return em.find(Product.class, id);
    }

    public void add(Product product){
        this.em.persist(product);
    }
    public void update(Product product){
        this.em.merge(product);
    }
    public void remove(Product product){
        product = em.merge(product);
        this.em.remove(product);
    }

}
