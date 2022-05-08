package com.qlds.qlds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlds.qlds.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
	List<Product> findAll();
	Product findOneByCode(String code);
}
