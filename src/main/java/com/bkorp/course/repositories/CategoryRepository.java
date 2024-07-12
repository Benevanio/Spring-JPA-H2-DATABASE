package com.bkorp.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkorp.course.entities.Orders;

public interface CategoryRepository extends JpaRepository<Orders, Long> {

}
