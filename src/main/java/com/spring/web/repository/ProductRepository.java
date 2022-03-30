package com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.web.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
