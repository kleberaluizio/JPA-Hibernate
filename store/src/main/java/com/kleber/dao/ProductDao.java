package com.kleber.dao;

import com.kleber.model.Product;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductDao {
    private EntityManager em;


    public ProductDao(EntityManager em) {
        this.em = em;
    }

    public Product findById(Long id){
        return em.find(Product.class, id);
    }

    public List<Product> findByName(String name){
        String JPQL = "SELECT p FROM Product p WHERE p.name = :name";
        return em.createQuery(JPQL)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Product> findByCategory(String category){
        String JPQL = "SELECT p FROM Product p WHERE p.category.name = :name";
        return em.createQuery(JPQL)
                .setParameter("name", category)
                .getResultList();
    }

    public BigDecimal findProductPriceByName (String name){
        String JPQL = "SELECT p.price FROM Product p WHERE p.name = :name";
        return em.createQuery(JPQL, BigDecimal.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<Product> findAll(){
        String JPQL = "SELECT p FROM Product p";
        return em.createQuery(JPQL).getResultList();
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
