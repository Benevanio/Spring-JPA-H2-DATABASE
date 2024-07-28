package com.bkorp.course.services;

import java.util.List;
import java.util.Optional;

import com.bkorp.course.entities.pk.OrderItemPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkorp.course.entities.OrderItem;
import com.bkorp.course.repositories.OrderItemRepository;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    public OrderItem findById(OrderItemPK id) {
        Optional<OrderItem> obj = orderItemRepository.findById(id);
        return obj.get();
    }
}
