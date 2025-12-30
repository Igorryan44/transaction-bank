package com.igor_dev.transaction_bank.servcice;

import com.igor_dev.transaction_bank.model.Transaction;
import com.igor_dev.transaction_bank.model.User;
import com.igor_dev.transaction_bank.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.igor_dev.transaction_bank.enums.TransactionStatus.*;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction sendTransaction(Transaction transaction, User user) {
        if (transaction.getValue() <= 0 && user.getBalance() > transaction.getValue()) {
            transaction.setPayer(user.getId());
            transaction.setStatus(String.valueOf(DENIED));
            transaction.setMessage("Transação não autorizada");
            return transactionRepository.save(transaction);
        }

        transaction.setPayer(user.getId());
        transaction.setStatus(String.valueOf(APPROVED));
        transaction.setMessage("Transferência realizada com sucesso");
        return transactionRepository.save(transaction);
    }




}
