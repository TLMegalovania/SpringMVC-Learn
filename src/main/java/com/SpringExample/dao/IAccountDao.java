package com.SpringExample.dao;

import com.SpringExample.model.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {

    void saveAccount();

    int save(Account account);
    int update(Account account);
    int delete(Account account);
    Account findById(Integer id);
    List<Account> findByName(String name);
    List<Account> findAll();

}
