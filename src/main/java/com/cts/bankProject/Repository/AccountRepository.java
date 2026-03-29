package com.cts.bankProject.Repository;

import com.cts.bankProject.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account , Long> {

    Optional<Account> findByEmailId(String emailId);
    Optional<Account> findByAccountNumber(Long accountNumber);
    boolean existsByAccountNumber(Long accountNumber);
    boolean existsByEmailId(String emailId);


}
