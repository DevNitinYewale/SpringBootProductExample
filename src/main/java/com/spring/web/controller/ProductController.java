package com.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.entity.Product;
import com.spring.web.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService prodService;
	
	//DISPLAY DATA 
	@RequestMapping("/")
	public String homePage(Model model) {
		List<Product> listProduct=prodService.getAll();
		model.addAttribute("listProducts",listProduct);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Product product=new Product();
		model.addAttribute("product",product);
		
		return "new_product";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		prodService.save(product);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name= "id") Integer id) {
		ModelAndView mav=new ModelAndView("edit_product");
		Product product=prodService.get(id);
		mav.addObject("product", product);
		
		return mav;
	}
	

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		prodService.delete(id);
		return"redirect:/";
	}
	
}