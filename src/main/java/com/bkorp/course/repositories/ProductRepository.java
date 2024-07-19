package com.bkorp.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkorp.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
