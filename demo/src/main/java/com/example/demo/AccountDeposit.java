package com.example.demo;
import com.example.demo.Account;

public class AccountDeposit extends Account{
    public AccountDeposit(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
