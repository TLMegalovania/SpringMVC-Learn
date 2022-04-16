package com.SpringExample.dao;

import com.SpringExample.model.Account;

import java.util.List;

/**
 * 账户的持久层实现1
 */
public class AccountDaoImpl_1  implements  IAccountDao{

    public void saveAccount() {
        System.out.println("这是" + this.getClass().getName() + "保存了我的账户");
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
