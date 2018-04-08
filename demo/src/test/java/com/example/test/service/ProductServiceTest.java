package com.example.test.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.Product;
import com.example.service.ProductService;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
@SpringBootTest
public class ProductServiceTest {
	@Injectable
	ProductService productService;
	
	@Tested
	Product product;
	
	private static Product p1;
	
	@Test
	public void testaddproduct()
{

}
}
