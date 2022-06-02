package com.example.demo;

import com.example.demo.account.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;

    private  BankCore bankCore;

    public List<Account> getAccounts() {
        return accountRepository.getAccounts();
    }
    public Account getAccountById(String id) {
        return accountRepository.findByIdEquals(id);
    }

    public void deposit(String accountId, double amount) {
        Account account = accountRepository.findAccountByIdAndClientID(accountId, "1");
        double balance = account.getBalance() + amount;
        accountRepository.updateAccount(accountId, balance);
    }

}
