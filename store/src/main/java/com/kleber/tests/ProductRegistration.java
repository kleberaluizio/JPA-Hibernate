package com.kleber.tests;

import com.kleber.dao.ProductDao;
import com.kleber.dao.CategoryDao;
import com.kleber.model.Category;
import com.kleber.model.Product;
import com.kleber.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class ProductRegistration {

    public static void main(String[] args) {
        registerProduct();

//        Long id = 1L;
//
//        EntityManager em = JPAUtil.getEntityManager();
//        ProductDao produtoDao = new ProductDao(em);
//
//        Product p = produtoDao.findById(id);
//
//        System.out.println(p);
//        System.out.println(p.getPrice());
    }

    private static void registerProduct() {
        Category cellphones = new Category("CELLPHONES");

        Product cellphone = new Product();
        cellphone.setName("Samsung Galaxy A50");
        cellphone.setDescription("Super rápido");
        cellphone.setPrice(new BigDecimal("940"));
        cellphone.setCategory(cellphones);

        EntityManager em = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(em);
        CategoryDao categoryDao = new CategoryDao(em);

        em.getTransaction().begin();

        categoryDao.add(cellphones);
        productDao.add(cellphone);

        em.persist(cellphone);
        cellphone.setDescription("Pretty Fast!");
        em.flush();
        em.clear();

        cellphone = em.merge(cellphone);
        cellphone.setName("Iphone");
        em.flush();
    }
}
