package com.mybankonline.userfront.dao;

import com.mybankonline.userfront.domain.PrimaryAccount;
import org.springframework.data.repository.CrudRepository;

public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount, Long> {
    PrimaryAccount findByAccountNumber(int accountNumber);
}
