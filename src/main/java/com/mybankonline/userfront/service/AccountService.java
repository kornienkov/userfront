package com.mybankonline.userfront.service;

import com.mybankonline.userfront.domain.PrimaryAccount;
import com.mybankonline.userfront.domain.SavingsAccount;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface AccountService {

    PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
    void deposit(String s, double d, Principal p);
    void withdraw(String s, double d, Principal p);
}
