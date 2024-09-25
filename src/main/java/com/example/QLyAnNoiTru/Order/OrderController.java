package com.example.QLyAnNoiTru.Order;


import com.example.QLyAnNoiTru.Account.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    public final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //Method to find all order
    @GetMapping()
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    //Method to create new order
    @PostMapping("/create")
    public void createOrder(@RequestBody Order order) {
        orderRepository.createOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderRepository.deleteOrder(id);
    }
}
