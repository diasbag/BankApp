package com.example.demo;

import com.example.demo.account.Account;
import com.example.demo.transaction.Transaction;
import com.example.demo.transaction.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransactionController {

    private TransactionService transactionService;
    private TransactionRepository transactionRepository;

    @GetMapping("/accounts/{accountId}/transactions")
    public List<Transaction> getTransactions(@PathVariable String accountId) {
        return transactionService.getTransactions(accountId);
    }
    @PostMapping(value = "/{id}/deposit", consumes = "application/json")
    public String deposit(@PathVariable String id, @RequestBody TransactionRequest transactionRequest) {
        return transactionService.deposit(id, transactionRequest);
    }
    @PostMapping(value = "/{id}/withdraw", consumes = "application/json")
    public String withdraw(@PathVariable String id, @RequestBody TransactionRequest transactionRequest) {
        return transactionService.deposit(id, transactionRequest);
    }
}
