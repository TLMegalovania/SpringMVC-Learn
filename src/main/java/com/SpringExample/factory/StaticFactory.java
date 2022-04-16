package com.SpringExample.factory;

import com.SpringExample.dao.AccountDaoImpl_1;
import com.SpringExample.dao.IAccountDao;
import com.SpringExample.service.AccountServiceImpl_1;
import com.SpringExample.service.IAccountService;

public class StaticFactory {

    public static IAccountDao createAccountDao(){
        return new AccountDaoImpl_1();
    }
    public static IAccountService createAccountService(){
        return new AccountServiceImpl_1();
    }
}
