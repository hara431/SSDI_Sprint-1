package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UserController {
	@RequestMapping(value="/userpages/userview", method = RequestMethod.GET)
	public ModelAndView userproducts(){
		ModelAndView modelAndView = new ModelAndView("redirect:/userpages/userview");
		System.out.println("in the contrlooer**");
/*		Product product = new Product();
		modelAndView.addObject("product", product);*/
		modelAndView.setViewName("/userpages/userview");
		return modelAndView;
	}
}
