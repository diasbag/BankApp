package com.example.demo.account;


public class FixedAccount extends AccountDeposit {
    public FixedAccount(String accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
