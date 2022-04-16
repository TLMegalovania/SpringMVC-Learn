package com.SpringExample.service;

import com.SpringExample.dao.IAccountDao;
import com.SpringExample.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//初始化交给Spring通过注解去完成
//==>IAccountService accountService4 = AccountServiceImpl_4();
@Service(value="accountService4")
public class AccountServiceImpl_4 implements IAccountService {

    // 自动按照类型注入，可能会找到多个同类型的bean，产生歧义，仅限于同类型对象唯一时使用，且必须删除当前类的setter函数
    //@Autowired
    //在自动按照类型注入的基础之上，再按照 Bean 的 id 注入。它在给字段注入时不能独立使用，必须和@Autowire 一起使用；但是给方法参数注入时，可以独立使用
    //@Qualifier(value="accountBean4")
    //直接按照 Bean 的 id 注入。它也只能注入其他 bean 类型,通过name，指定bean的id
    @Resource(name="accountDao4")  //==>accountDao = accountDao4; accountDao3
    private IAccountDao accountDao;

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
