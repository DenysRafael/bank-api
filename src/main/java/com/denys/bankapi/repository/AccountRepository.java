package com.denys.bankapi.repository;

import com.denys.bankapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByActiveTrue();
    Optional<Account> findByCpf(String cpf);
    boolean existsByCpf(String cpf);
}
