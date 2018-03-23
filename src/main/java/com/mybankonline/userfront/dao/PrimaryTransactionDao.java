package com.mybankonline.userfront.dao;

import com.mybankonline.userfront.domain.PrimaryTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long>{

    List<PrimaryTransaction> findAll();
}
