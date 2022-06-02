package com.example.demo.transaction;

import com.example.demo.AccountRepository;
import com.example.demo.TransactionRepository;
import com.example.demo.TransactionRequest;
import com.example.demo.account.Account;
import com.example.demo.services.AccountListingService;
import com.example.demo.services.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;
    private AccountWithdrawService accountWithdrawService;

    public List<Transaction> getTransactions(String accountID) {
        return transactionRepository.findAllByAccountId(accountID);
    }

    public String deposit(String accountId, TransactionRequest transactionRequest) {
        Account account = accountRepository.findAccountByIdAndClientID(accountId, "1");
        if (account == null) {
            System.out.println("Account does not exist!!!");
        }
        accountRepository.updateAccount(account.getId(), transactionRequest.getAmount());
        Transaction transaction = Transaction.builder().
                amount(transactionRequest.getAmount()).
                accountId(accountId).
                build();
        Transaction createdTransaction = transactionRepository.save(transaction);
        return createdTransaction.getAccountId();
    }

    public String withdraw(String accountId, TransactionRequest transactionRequest) {
        Account account = accountRepository.findAccountByIdAndClientID(accountId, "1");
        if (account == null) {
            System.out.println("Account does not exist!!!");
        }
        double amount = transactionRequest.getAmount();
        accountWithdrawService.withdraw(transactionRequest.getAmount(), account);
        Transaction transaction = Transaction.builder().
                amount(transactionRequest.getAmount()).
                accountId(accountId).
                build();
        Transaction createdTransaction = transactionRepository.save(transaction);
        return createdTransaction.getAccountId();
    }
}
