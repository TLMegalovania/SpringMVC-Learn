package com.SpringExample.dao;

import com.SpringExample.model.Account;
import org.omg.CORBA.INTERNAL;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class AccountDaoImpl_3 implements  IAccountDao {

    public String name;
    public int money;
    public Date birthday;
    public Set<String> testSet;

    public void setName(String _name) {
        this.name = _name;
    }
    public void setMoney(int _money) {
        this.money = _money;
    }
    public void setBirthday(Date _birthday) {
        this.birthday = _birthday;
    }
    public void setTestSet(Set<String> _set){this.testSet = _set;}

    public AccountDaoImpl_3(){

    }

    public AccountDaoImpl_3(String _name, int _money){
        name = _name;
        money = _money;
    }

    public void saveAccount() {
        System.out.println("这是" + this.getClass().getName() + "保存了你的账户");

        for (int i=0; i < testSet.size(); i++)
            System.out.println(testSet.toArray()[i]);

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
