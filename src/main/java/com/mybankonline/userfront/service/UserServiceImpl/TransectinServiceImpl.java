package com.mybankonline.userfront.service.UserServiceImpl;

import com.mybankonline.userfront.dao.PrimaryTransactionDao;
import com.mybankonline.userfront.dao.SavingsTransactionDao;
import com.mybankonline.userfront.domain.PrimaryTransaction;
import com.mybankonline.userfront.domain.SavingsTransaction;
import com.mybankonline.userfront.domain.User;
import com.mybankonline.userfront.service.TransactionService;
import com.mybankonline.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransectinServiceImpl implements TransactionService{

    @Autowired
    private UserService userService;

    @Autowired
    private PrimaryTransactionDao primaryTransactionDao;

    @Autowired
    private SavingsTransactionDao savingsTransactionDao;

    public List<PrimaryTransaction> findPrimaryTransactionList(String username){
        User user = userService.findByUsername(username);
        List<PrimaryTransaction> primaryTransactions = user.getPrimaryAccount().getPrimaryTransactionList();

        return primaryTransactions;
    }

    public List<SavingsTransaction> findSavingsTransactionList(String username){
        User user = userService.findByUsername(username);
        List<SavingsTransaction> savingsTransactions = user.getSavingsAccount().getSavingsTransactionList();

        return savingsTransactions;
    }

    public void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction){
        primaryTransactionDao.save(primaryTransaction);
    }

    public void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction){
        savingsTransactionDao.save(savingsTransaction);
    }

    public void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction){
        primaryTransactionDao.save(primaryTransaction);
    }

    public void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction){
        savingsTransactionDao.save(savingsTransaction);
    }

}
