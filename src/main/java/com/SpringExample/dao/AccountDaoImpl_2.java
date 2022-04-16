package com.SpringExample.dao;

import com.SpringExample.model.Account;

import java.util.List;

public class AccountDaoImpl_2 implements  IAccountDao {

    public void saveAccount() {
        System.out.println("这是" + this.getClass().getName() + "保存了你的账户");
    }

    public int save(Account account) {
        return 0;
    }

    public int update(Account account) {
        return 0;
    }

    public int delete(Account account) {
        return 0;
    }

    public Account findById(Integer id) {
        return null;
    }

    public List<Account> findByName(String name) {
        return null;
    }

    public List<Account> findAll() {
        return null;
    }
}
