package com.SpringExample.service;

import com.SpringExample.dao.IAccountDao;
import com.SpringExample.model.Account;

import java.util.List;

//初始化交给Spring通过XML配置文件去完成
public class AccountServiceImpl_3 implements  IAccountService{

    private IAccountDao accountDao ;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

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
