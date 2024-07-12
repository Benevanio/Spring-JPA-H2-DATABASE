package com.bkorp.course.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkorp.course.entities.Orders;
import com.bkorp.course.repositories.OrderRepository;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<Orders>> findAll() {
        List<Orders> list = orderRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Orders> findById(@PathVariable Long id) {
        Optional<Orders> obj = orderRepository.findById(id);
        return ResponseEntity.ok().body(obj.get());
    }

}
