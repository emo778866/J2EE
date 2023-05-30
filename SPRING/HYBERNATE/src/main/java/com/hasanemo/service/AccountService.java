package com.hasanemo.service;


import com.hasanemo.dao.AccountDAO;
import com.hasanemo.dto.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    final
    AccountDAO accountDAO;

    public AccountService(@Qualifier("AccountDAOImp2") AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account findById(long id) {
        return accountDAO.findByAccountId(id);
    }

    public void saveAccount(Account account) {
        accountDAO.save(account);
    }

    public void update(Account account) {
        accountDAO.update(account);
    }

    public void deleteAccount(Account account) {
        accountDAO.delete(account);
    }

    public List<Account> getAllAccounts() {
        return accountDAO.accountList();
    }

    public ResponseEntity<Object> transferBalance(long sId, long rId, long amount) {

        Account sender = accountDAO.findByAccountId(sId);
        Account receiver = accountDAO.findByAccountId(rId);

        if (sender.getBalance() >= amount && sender.getBalance() != null) {
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);
            accountDAO.update(sender);
            accountDAO.update(receiver);
            return new ResponseEntity<>("Successfully transferred to " + receiver.getFirstName() + "'s account.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something unexpected happened :(", HttpStatus.BAD_GATEWAY);
        }
    }
}
