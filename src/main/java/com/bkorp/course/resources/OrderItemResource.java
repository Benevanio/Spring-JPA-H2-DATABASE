package com.bkorp.course.resources;

import java.util.List;
import java.util.Optional;

import com.bkorp.course.entities.pk.OrderItemPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkorp.course.entities.OrderItem;
import com.bkorp.course.repositories.OrderItemRepository;

@RestController
@RequestMapping(value = "/orderitems")
public class OrderItemResource {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping
    public ResponseEntity<List<OrderItem>> findAll() {
        List<OrderItem> list = orderItemRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderItem> findById(@PathVariable OrderItemPK id) {
        Optional<OrderItem> obj = orderItemRepository.findById(id);
        return ResponseEntity.ok().body(obj.get());
    }

}
