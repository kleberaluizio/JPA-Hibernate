package com.kleber.tests;

import com.kleber.dao.ProductDao;
import com.kleber.dao.CategoryDao;
import com.kleber.model.Category;
import com.kleber.model.Product;
import com.kleber.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductRegistration {

    public static void main(String[] args) { Category cellphones = new Category("CELLPHONES");

        Product cellphone = new Product();
        cellphone.setName("Samsung Galaxy A50");
        cellphone.setDescription("Super rápido");
        cellphone.setPrice(new BigDecimal("940"));
        cellphone.setCategory(cellphones);

        Category computer = new Category("COMPUTERS");

        Product comp = new Product();
        comp.setName("XIAOMI");
        comp.setDescription("Super rápido");
        comp.setPrice(new BigDecimal("1460"));
        comp.setCategory(computer);


        EntityManager em = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(em);
        CategoryDao categoryDao = new CategoryDao(em);

        em.getTransaction().begin();

        categoryDao.add(cellphones);
        productDao.add(cellphone);

        categoryDao.add(computer);
        productDao.add(comp);

        em.persist(cellphone);
        em.persist(comp);
        cellphone.setDescription("Pretty Fast!");
        em.flush();
        em.clear();

        cellphone = em.merge(cellphone);
        cellphone.setName("Iphone");
        em.getTransaction().commit();

        Long id = 1L;

        Product p = productDao.findById(id);

        System.out.println(p);
        System.out.println(p.getPrice());

//        List<Product> todos = productDao.findByName("Iphone");
//        todos.forEach(p2 -> System.out.println(p2.getName()));

        List<Product> todos1 = productDao.findByCategory("COMPUTERS");
        todos1.forEach(p3 -> System.out.println(p3.getName() + " : " + p3.getCategory() ));

        BigDecimal price = productDao.findProductPriceByName("XIAOMI");
        System.out.println(price);
    }

    private static void registerProduct() {
        Category cellphones = new Category("CELLPHONES");

        Product cellphone = new Product();
        cellphone.setName("Samsung Galaxy A50");
        cellphone.setDescription("Super rápido");
        cellphone.setPrice(new BigDecimal("940"));
        cellphone.setCategory(cellphones);

        Category computer = new Category("COMPUTERS");

        Product comp = new Product();
        comp.setName("XIAOMI ");
        comp.setDescription("Super rápido");
        comp.setPrice(new BigDecimal("1460"));
        comp.setCategory(computer);


        EntityManager em = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(em);
        CategoryDao categoryDao = new CategoryDao(em);

        em.getTransaction().begin();

        categoryDao.add(cellphones);
        productDao.add(cellphone);

        categoryDao.add(computer);
        productDao.add(comp);

        em.persist(cellphone);
        em.persist(comp);
        cellphone.setDescription("Pretty Fast!");
        em.flush();
        em.clear();

        cellphone = em.merge(cellphone);
        cellphone.setName("Iphone");
        em.flush();
    }
}
