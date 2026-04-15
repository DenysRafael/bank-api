package com.denys.bankapi.service;

import com.denys.bankapi.dto.TransactionDTO;
import com.denys.bankapi.model.Account;
import com.denys.bankapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public List<Account> findAll() {
        return repository.findByActiveTrue();
    }

    public Account findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada"));
    }

    public Account create(Account account) {
        if (repository.existsByCpf(account.getCpf())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF já cadastrado");
        }
        return repository.save(account);
    }

    public Account update(Long id, Account updatedAccount) {
        Account existing = findById(id);
        existing.setOwnerName(updatedAccount.getOwnerName());
        existing.setAccountType(updatedAccount.getAccountType());
        return repository.save(existing);
    }

    public void delete(Long id) {
        Account account = findById(id);
        account.setActive(false); // soft delete
        repository.save(account);
    }

    public Account deposit(Long id, TransactionDTO dto) {
        Account account = findById(id);
        account.setBalance(account.getBalance().add(dto.getAmount()));
        return repository.save(account);
    }

    public Account withdraw(Long id, TransactionDTO dto) {
        Account account = findById(id);
        if (account.getBalance().compareTo(dto.getAmount()) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saldo insuficiente");
        }
        account.setBalance(account.getBalance().subtract(dto.getAmount()));
        return repository.save(account);
    }
}
