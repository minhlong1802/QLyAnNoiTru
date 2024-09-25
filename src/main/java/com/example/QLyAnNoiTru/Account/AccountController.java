package com.example.QLyAnNoiTru.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountRepository accountRepository;
    private final JdbcTemplateService jdbcTemplateService;

    @Autowired
    public AccountController(AccountRepository accountRepository,JdbcTemplateService jdbcTemplateService) {
        this.accountRepository = accountRepository;
        this.jdbcTemplateService = jdbcTemplateService;
    }

    @GetMapping
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
    // Phương thức để xem chi tiết sản phẩm theo id
    @GetMapping("/id/{id}")
    Account findById(@PathVariable String id) {
        Optional<Account> account = Optional.ofNullable(accountRepository.findById(id));
        return account.get();
    }
    // Phương thức để xem chi tiết sản phẩm theo username
    @GetMapping("/username/{username}")
    Account findByUsername(@PathVariable String username) {
        Optional<Account> account = Optional.ofNullable(accountRepository.findByUsername(username));
        return account.get();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody Account account) {
        accountRepository.create(account);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Account account) {
        accountRepository.update(account);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        accountRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sorted")
    public List<Account> findAllSortedByRole() {
        return accountRepository.findAllSortedByRole();
    }
    @GetMapping("/user-details/{username}")
    public ResponseEntity<Object> findUserDetailsByUsername(@PathVariable String username) {
        try {
            Object userDetails = jdbcTemplateService.findUserDetailsByUsername(username);
            return ResponseEntity.ok(userDetails);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // Controller method to change the password
    @PutMapping("/change-password/{id}")
    public ResponseEntity<Void> changePassword(@PathVariable String id, @RequestBody ChangePasswordRequest request) {
        Optional<Account> account = Optional.ofNullable(accountRepository.findById(id));

        if (account.isPresent()) {
            // Update the password
            accountRepository.changePassword(id, request.getNewPasswordHash());
            return ResponseEntity.noContent().build();
        } else {
            // If the account does not exist, return a 404 Not Found status
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // A simple DTO to encapsulate the change password request
    public static class ChangePasswordRequest {
        private String newPasswordHash;

        public String getNewPasswordHash() {
            return newPasswordHash;
        }

        public void setNewPasswordHash(String newPasswordHash) {
            this.newPasswordHash = newPasswordHash;
        }
    }
}
