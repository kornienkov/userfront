package com.mybankonline.userfront.service;

import com.mybankonline.userfront.domain.PrimaryAccount;
import com.mybankonline.userfront.domain.SavingsAccount;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();

}
