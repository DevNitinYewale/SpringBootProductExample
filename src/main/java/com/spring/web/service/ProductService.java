package com.spring.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.entity.Product;
import com.spring.web.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductRepository prodRepo;
	
	//Display Data
	public List<Product> getAll(){
		return prodRepo.findAll();
	}
	
	//Save Data
	public void save(Product product) {
		prodRepo.save(product);
	}
	
	//Find By id
	public Product get(Integer id) {
		return prodRepo.findById(id).get();
	}
	
	//Delete by id
	public void delete(Integer id) {
		prodRepo.deleteById(id);
	}
}
