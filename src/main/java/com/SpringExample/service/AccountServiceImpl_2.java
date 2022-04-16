package com.SpringExample.service;

import com.SpringExample.dao.IAccountDao;
import com.SpringExample.factory.MyBeanFactoryMulti;
import com.SpringExample.model.Account;

import java.util.List;

/**
 * 账户的业务服务层的实现2：通过工厂方法获取所依赖的对象
 */
public class AccountServiceImpl_2  implements  IAccountService{

    private IAccountDao accountDao2 = (IAccountDao) MyBeanFactoryMulti.getBean("accountDao");

    public void saveAccount() {
        accountDao2.saveAccount();
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
