package com.example.QLyAnNoiTru.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kitchen-employee")
public class KitchenEmployeeController {
    private final KitchenEmployeeRepository kitchenEmployeeRepository;
    private final JdbcTemplateService jdbcTemplateService;

    @Autowired
    public KitchenEmployeeController(KitchenEmployeeRepository kitchenEmployeeRepository,JdbcTemplateService jdbcTemplateService) {
        this.kitchenEmployeeRepository = kitchenEmployeeRepository;
        this.jdbcTemplateService = jdbcTemplateService;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody KitchenEmployee kitchenEmployee) {
        kitchenEmployeeRepository.update(kitchenEmployee);
        return ResponseEntity.noContent().build();
    }

}
