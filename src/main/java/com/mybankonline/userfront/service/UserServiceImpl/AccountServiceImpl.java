package com.mybankonline.userfront.service.UserServiceImpl;

import com.mybankonline.userfront.dao.PrimaryAccountDao;
import com.mybankonline.userfront.dao.SavingsAccountDao;
import com.mybankonline.userfront.domain.PrimaryAccount;
import com.mybankonline.userfront.domain.SavingsAccount;
import com.mybankonline.userfront.service.AccountService;
import com.mybankonline.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService{

    private static int nextAccountNumber = 11223145;

    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Autowired
    private SavingsAccountDao savingsAccountDao;

//    @Autowired
//    private UserService userService;

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

}
