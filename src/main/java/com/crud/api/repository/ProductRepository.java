package com.crud.api.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}
