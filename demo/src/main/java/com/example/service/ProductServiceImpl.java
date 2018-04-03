package com.example.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Product;
import com.example.repository.ProductRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;


@Service("productService")
public class ProductServiceImpl implements ProductService{
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SessionFactory sessionFactory;
	/*
	@PersistenceContext
    private EntityManager entityManger;*/	
	
	  @Autowired
	  private EntityManagerFactory entityManagerFactory;
	    //private EntityManager entityManager;

	public void addProduct(Product product){
		System.out.println("in servc");
		productRepository.save(product);
		
	}
	@Override
	@Transactional
	public void saveOrUpdate(int productId){	
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		 session.createQuery("UPDATE FROM Product p WHERE product_id=" + productId).executeUpdate();
		
	}
	@Override
	@Transactional
    public void delete(int productId) {
    	Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
    	session.createQuery("DELETE FROM Product p WHERE product_id=" + productId).executeUpdate();
        
    }
	@Override
	@Transactional
    public List<Product> listProducts() {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
    	List<Product> productList = session.createQuery("select p from Product p").list();
		return productList;
    }
	
}
