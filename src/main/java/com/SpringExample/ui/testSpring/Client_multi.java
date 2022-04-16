package com.SpringExample.ui.testSpring;

import com.SpringExample.factory.MyBeanFactoryMulti;
import com.SpringExample.service.IAccountService;

public class Client_multi {

    public static void main(String[] args){

        for (int i=0; i < 5; i++){
            IAccountService accountService = (IAccountService) MyBeanFactoryMulti.getBean("accountService");
            accountService.saveAccount();
            System.out.println(accountService);
        }
    }
}
