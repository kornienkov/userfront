package com.mybankonline.userfront.dao;

import com.mybankonline.userfront.domain.SavingsAccount;
import org.springframework.data.repository.CrudRepository;

public interface SavingsAccountDao  extends CrudRepository<SavingsAccount, Long>{
    SavingsAccount findByAccountNumber(int accountNumber);
}

