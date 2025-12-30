package com.igor_dev.transaction_bank.repository;

import com.igor_dev.transaction_bank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    public Long getValue();
}
