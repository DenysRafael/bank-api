package com.denys.bankapi.controller;

import com.denys.bankapi.dto.TransactionDTO;
import com.denys.bankapi.model.Account;
import com.denys.bankapi.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Account> create(@Valid @RequestBody Account account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable Long id, @Valid @RequestBody Account account) {
        return ResponseEntity.ok(service.update(id, account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable Long id, @Valid @RequestBody TransactionDTO dto) {
        return ResponseEntity.ok(service.deposit(id, dto));
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable Long id, @Valid @RequestBody TransactionDTO dto) {
        return ResponseEntity.ok(service.withdraw(id, dto));
    }
}
