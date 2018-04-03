package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UserController {
	@RequestMapping(value={"/userproducts"}, method = RequestMethod.GET)
	public ModelAndView productsview(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/userproducts");
		return modelAndView;
	}
}
