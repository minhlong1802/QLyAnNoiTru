package com.example.QLyAnNoiTru.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuRepository menuRepository;

    @Autowired
    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // Method to find all records
    @GetMapping()
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    // Method to create a new record
    @PostMapping()
    public void create(@RequestBody Menu menu) {
        menuRepository.create(menu);
    }

    // Method to update a record
    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Menu menu) {
        menuRepository.update(menu);
    }

    // Method to delete a record
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        menuRepository.delete(id);
    }
}
