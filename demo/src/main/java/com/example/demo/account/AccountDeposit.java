package com.example.demo.account;
import com.example.demo.account.Account;
import com.example.demo.account.AccountType;

public class AccountDeposit extends Account{
    public AccountDeposit(String accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
