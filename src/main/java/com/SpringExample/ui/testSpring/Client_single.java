package com.SpringExample.ui.testSpring;

import com.SpringExample.factory.MyBeanFactorySingle;
import com.SpringExample.service.IAccountService;

public class Client_single {

    public static void main(String[] args){

        for (int i=0; i < 5; i++){
            IAccountService accountService = (IAccountService) MyBeanFactorySingle.getBean("accountService");
            accountService.saveAccount();
            System.out.println(accountService);
        }
    }
}
