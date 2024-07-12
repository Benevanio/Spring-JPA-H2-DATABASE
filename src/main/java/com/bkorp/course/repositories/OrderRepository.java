package com.bkorp.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkorp.course.entities.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
