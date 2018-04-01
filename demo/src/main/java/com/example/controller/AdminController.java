package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Product;
import com.example.service.ProductService;


@Controller
public class AdminController {
	
	@Autowired
	private ProductService productService;
	@RequestMapping(value="/admin/addproduct", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		ModelAndView modelAndView = new ModelAndView();
		Product product = new Product();
		modelAndView.addObject("product", product);
		modelAndView.setViewName("/admin/addproduct");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/addproduct", method = RequestMethod.POST)
	public ModelAndView createNewProduct(@Valid Product product, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("/admin/addproduct");
		} else {
			productService.addProduct(product);
			modelAndView.addObject("successMessage", "Product has been added successfully");
			modelAndView.addObject("product", new Product());
			modelAndView.setViewName("/admin/addproduct");
			
		}
		return modelAndView;
	}
}
