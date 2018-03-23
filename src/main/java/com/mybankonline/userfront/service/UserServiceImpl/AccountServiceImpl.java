package com.mybankonline.userfront.service.UserServiceImpl;

import com.mybankonline.userfront.dao.PrimaryAccountDao;
import com.mybankonline.userfront.dao.PrimaryTransactionDao;
import com.mybankonline.userfront.dao.SavingsAccountDao;
import com.mybankonline.userfront.dao.SavingsTransactionDao;
import com.mybankonline.userfront.domain.*;
import com.mybankonline.userfront.service.AccountService;
import com.mybankonline.userfront.service.TransactionService;
import com.mybankonline.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService{

    private static int nextAccountNumber = 11223145;

    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Autowired
    private SavingsAccountDao savingsAccountDao;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Override
    public PrimaryAccount createPrimaryAccount() {
        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(accountGen());

        primaryAccountDao.save(primaryAccount);

        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
    }

    @Override
    public SavingsAccount createSavingsAccount() {
        SavingsAccount SavingsAccount = new SavingsAccount();
        SavingsAccount.setAccountBalance(new BigDecimal(0.0));
        SavingsAccount.setAccountNumber(accountGen());

        savingsAccountDao.save(SavingsAccount);

        return savingsAccountDao.findByAccountNumber(SavingsAccount.getAccountNumber());
    }

    private int accountGen(){
        return ++nextAccountNumber;
    }

    public void deposit(String accountType, double amount, Principal principal){
        User user = userService.findByUsername(principal.getName());

        if(accountType.equalsIgnoreCase("Primary")){

            PrimaryAccount primaryAccount = user.getPrimaryAccount();
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
            primaryAccountDao.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Deposit to Primary Account", "Account", "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);

            transactionService.savePrimaryDepositTransaction(primaryTransaction);

        }else if(accountType.equalsIgnoreCase("savings")){

            SavingsAccount savingsAccount = user.getSavingsAccount();
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().add(new BigDecimal(amount)));
            savingsAccountDao.save(savingsAccount);

            Date date = new Date();

            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Deposit to Savings Account", "Account", "Finished", amount, savingsAccount.getAccountBalance(), savingsAccount);

            transactionService.saveSavingsDepositTransaction(savingsTransaction);

        }

    }

    public void withdraw(String accountType, double amount, Principal principal){
        User user = userService.findByUsername(principal.getName());

        if(accountType.equalsIgnoreCase("Primary")){

            PrimaryAccount primaryAccount = user.getPrimaryAccount();
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            primaryAccountDao.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Withdraw from Primary Account", "Account", "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);

            transactionService.savePrimaryWithdrawTransaction(primaryTransaction);

        }else if(accountType.equalsIgnoreCase("savings")){

            SavingsAccount savingsAccount = user.getSavingsAccount();
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            savingsAccountDao.save(savingsAccount);

            Date date = new Date();

            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Withdraw from  Savings Account", "Account", "Finished", amount, savingsAccount.getAccountBalance(), savingsAccount);

            transactionService.saveSavingsWithdrawTransaction(savingsTransaction);
        }

    }

}
