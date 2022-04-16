package com.SpringExample.service;

import com.SpringExample.dao.AccountDaoImpl_1;
import com.SpringExample.dao.IAccountDao;
import com.SpringExample.model.Account;

import java.util.List;

/**
 * 账户的业务服务层的实现1: 直接调用产生依赖
 */
public class AccountServiceImpl_1 implements  IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl_1();

    public void saveAccount() {
        accountDao.saveAccount();
    }

    public boolean add(Account account) {
        return true;
    }

    public boolean update(Account account) {
        return true;
    }

    public boolean delete(Account account) {
        return true;
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
