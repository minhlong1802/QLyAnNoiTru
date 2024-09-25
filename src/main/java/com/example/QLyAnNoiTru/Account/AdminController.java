package com.example.QLyAnNoiTru.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminRepository adminRepository;
    private final JdbcTemplateService jdbcTemplateService;

    @Autowired
    public AdminController(AdminRepository adminRepository,JdbcTemplateService jdbcTemplateService) {
        this.adminRepository = adminRepository;
        this.jdbcTemplateService = jdbcTemplateService;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Admin admin) {
        adminRepository.update(admin);
        return ResponseEntity.noContent().build();
    }

}
