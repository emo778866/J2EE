package com.hasanemo.controller;

import com.hasanemo.dto.Account;
import com.hasanemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController()
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/detail")
    public Account detail(@RequestParam long accountId) {
        return accountService.findById(accountId);
    }

    @PostMapping("/new")
    public void newAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
    }

    @PutMapping
    void updateAccount(@RequestBody Account account) {
        accountService.update(account);
    }

    @DeleteMapping("/delete")
    void delete(@RequestBody Account account) {
        accountService.deleteAccount(account);
    }

    @PostMapping("/transfer")
    public ResponseEntity<Object> transferBalance(@RequestParam long sId,
                                                  @RequestParam long rId,
                                                  @RequestParam long amount) {
        return accountService.transferBalance(sId, rId, amount);
    }

    @GetMapping()
    public List allAccount() {
        return accountService.getAllAccounts();
    }


}
