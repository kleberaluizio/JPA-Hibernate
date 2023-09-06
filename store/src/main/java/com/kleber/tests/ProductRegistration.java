package com.kleber.tests;

import com.kleber.dao.ProductDao;
import com.kleber.model.Product;
import com.kleber.util.JPAUtil;

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

        EntityManager em = JPAUtil.getEntityManager();

        ProductDao productDao = new ProductDao(em);

        em.getTransaction().begin();
        productDao.cadastrar(cellphone);
        em.getTransaction().commit();
        em.close();

    }
}
