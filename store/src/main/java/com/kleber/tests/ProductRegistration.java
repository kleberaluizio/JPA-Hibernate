package com.kleber.tests;

import com.kleber.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ProductRegistration {

    public static void main(String[] args) {
        Product cellphone = new Product();
        cellphone.setName("Xiaomi Redmi");
        cellphone.setDescription("Muito legal");
        cellphone.setPrice(new BigDecimal("800"));

        // Provided parameter is the name in persistence unit
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");

        EntityManager em = factory.createEntityManager();

        em.persist(cellphone);

    }
}
