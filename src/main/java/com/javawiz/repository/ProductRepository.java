package com.javawiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javawiz.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {}  