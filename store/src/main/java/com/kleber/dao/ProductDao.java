package com.kleber.dao;

import com.kleber.model.Product;

import javax.persistence.EntityManager;

public class ProductDao {
    private EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Product product){
        this.em.persist(product);
    }
    public void atualizar(Product product){
        this.em.merge(product);
    }
    public void remover(Product product){
        product = em.merge(product);
        this.em.remove(product);
    }

}
