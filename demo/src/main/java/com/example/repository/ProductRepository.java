package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

	@Repository("productrepository")
	public interface ProductRepository extends JpaRepository<Product, Long> {
	
	}


