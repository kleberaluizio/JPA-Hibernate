package com.kleber.tests;

import com.kleber.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ProductRegistration {

    public static void main(String[] args) {
        Product cellphone = new Product();
        cellphone.setName("Samsung Galaxy A50");
        cellphone.setDescription("Super rápido");
        cellphone.setPrice(new BigDecimal("940"));
//        cellphone.setName("Xiaomi Redmi");
//        cellphone.setDescription("Muito legal");
//        cellphone.setPrice(new BigDecimal("800"));

        // Provided parameter is the name in persistence unit
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");

        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(cellphone);
        em.getTransaction().commit();
        em.close();

    }
}
