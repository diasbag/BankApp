package com.example.demo;

import com.example.demo.account.Account;
import com.example.demo.transaction.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;
    private TransactionRepository transactionRepository;
    private  AccountRepository accountRepository;

    @GetMapping()
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable String id) {
        return accountService.getAccountById(id);
    }


//    @PostMapping(consumes = "application/json", produces = "application/json")
//    public String createAccount(@RequestBody AccountRequest accountRequest) {
//       return accountService.createAccount(accountRequest);
//    }

}
