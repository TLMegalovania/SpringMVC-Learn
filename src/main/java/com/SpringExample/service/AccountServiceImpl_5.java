package com.SpringExample.service;

import com.SpringExample.dao.IAccountDao;
import com.SpringExample.model.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//初始化交给Spring通过注解去完成
@Service(value="accountService5")
public class AccountServiceImpl_5 implements IAccountService {

    public final static SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss.SSSS");
    private long startTime = 0;
    private long endTime = 0;

    @Resource(name="accountDao5")
    private IAccountDao accountDao;

    public void saveAccount() {
        accountDao.saveAccount();
    }

    public boolean add(Account account) {
        int updated = accountDao.save(account);
        return updated > 0 ? true : false;
    }

    public boolean update(Account account) {
        int updated = accountDao.update(account);
        return updated > 0 ? true : false;
    }

    public boolean delete(Account account) {
        int updated = accountDao.delete(account);
        return updated > 0 ? true : false;
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    public List<Account> findByName(String name) {
        return accountDao.findByName(name);
    }

    public List<Account> findAll() {

        //startLog();

        String className = Thread.currentThread().getStackTrace()[2].getClassName();//调用的类名
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();//调用的方法名
        System.out.println(className + "." + methodName + " is executing...");

        List<Account> results =  accountDao.findAll();

        //endLog();
        return results;
    }

    public void startLog(){
        startTime = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start at:" + new Date());
        System.out.println(this.getClass().getName() + " start to log");
    }

    public void endLog(){
        endTime = System.currentTimeMillis();
        String text = df.format(new Date(startTime)) + " - " + df.format(new Date(endTime)) + "\t"
                + (endTime - startTime) / 1000.0 + "s";
        System.out.println(this.getClass().getName() + " 耗时:" + text);
        System.out.println(this.getClass().getName() + " end log");
        System.out.println(this.getClass().getName() + " end at:" + new Date());
    }
}
