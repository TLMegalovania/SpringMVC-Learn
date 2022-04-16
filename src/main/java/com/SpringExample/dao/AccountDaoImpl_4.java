package com.SpringExample.dao;

import com.SpringExample.model.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//==> IAccountDao accountDao4 = new AccountDaoImpl_4();
@Repository(value="accountDao4")
public class AccountDaoImpl_4 implements  IAccountDao {
    public void saveAccount() {
        System.out.println("这是" + this.getClass().getName() + "保存了我和你的账户");
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
