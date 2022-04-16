package com.SpringExample.ui.testSpring;

import com.SpringExample.service.AccountServiceImpl_1;
import com.SpringExample.service.AccountServiceImpl_2;
import com.SpringExample.service.IAccountService;

/**
 * 传统方法,产生直接依赖
 */
public class Client_direct {

    public static void main(String[] args){
        IAccountService accountService = new AccountServiceImpl_1();
        accountService.saveAccount();

        IAccountService accountService2 = new AccountServiceImpl_2();
        accountService2.saveAccount();

    }
}
