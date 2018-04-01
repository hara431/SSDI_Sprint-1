package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepository;

import java.util.List;


@Service("productService")
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	
	
	public void addProduct(Product product){
		System.out.println("in servc");
		productRepository.save(product);
		
	}
	public void saveOrUpdate(Product product){		
	}
    public void delete(int productId) {
        
    }
    
    public List<Product> ProductsView() {
    	return (List<Product>)productRepository.findAll();
    	
    }
 
}
