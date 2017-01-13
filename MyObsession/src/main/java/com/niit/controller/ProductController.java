package com.niit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.ProductDAOImpl;
import com.niit.model.Product;

@Controller
public class ProductController {


	ProductDAOImpl  productDAOImpl=new ProductDAOImpl();
	
	@RequestMapping("/addP")
	public ModelAndView addP()
	{
		ModelAndView mv= new ModelAndView("AddProduct");
		return mv;
	}
	
	
	@RequestMapping("/addproduct")
	public ModelAndView addProduct(@ModelAttribute Product p)
	{
		productDAOImpl.saveProduct(p);
		ModelAndView mv= new ModelAndView("redirect:/viewproduct");
		return mv;
	}
	
	@RequestMapping("/viewproduct")
	public ModelAndView m1()
	{
		//this is jsp filename
		ModelAndView mv=new ModelAndView("ViewProduct");
		
		List<Product> l=productDAOImpl.viewProduct();
		mv.addObject("List", l);
		return mv;
	}
	
	
	
}
