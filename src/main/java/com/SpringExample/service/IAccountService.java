package com.SpringExample.service;

import com.SpringExample.model.Account;

import java.util.List;

public interface IAccountService {

    void saveAccount();

    boolean add(Account account);
    boolean update(Account account);
    boolean delete(Account account);
    Account findById(Integer id);
    List<Account> findByName(String name);
    List<Account> findAll();
}
