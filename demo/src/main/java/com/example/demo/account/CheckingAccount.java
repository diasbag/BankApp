package com.example.demo.account;

public class CheckingAccount extends AccountWithdraw {

    public CheckingAccount(String accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
