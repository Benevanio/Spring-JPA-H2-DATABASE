package com.bkorp.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkorp.course.entities.OrderItem;
import com.bkorp.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}