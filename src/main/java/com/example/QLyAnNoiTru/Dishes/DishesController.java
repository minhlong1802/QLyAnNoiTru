package com.example.QLyAnNoiTru.Dishes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dishes")
public class DishesController {
    private final DishesRepository dishesRepository;

    @Autowired
    public DishesController(DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
    }

    // Method to find all records
    @GetMapping
    public java.util.List<Dishes> findAll() {
        return dishesRepository.findAll();
    }

    // Method to find record by id
    @GetMapping("/{id}")
    public Dishes findById(@PathVariable String id) {
        return dishesRepository.findById(id);
    }

    // Method to insert new record
    @PostMapping
    public void create(@RequestBody Dishes dishes) {
        dishesRepository.create(dishes);
    }

    // Method to update record
    @PutMapping("?{id}")
    public void update(@PathVariable String id, @RequestBody Dishes dishes) {
        dishesRepository.update(dishes);
    }

    // Method to delete record
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        dishesRepository.deleteById(id);
    }

}
