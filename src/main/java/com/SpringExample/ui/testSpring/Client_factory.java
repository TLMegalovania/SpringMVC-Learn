package com.SpringExample.ui.testSpring;

import com.SpringExample.factory.MyBeanFactoryMulti;
import com.SpringExample.service.IAccountService;

/**
 * 通过工厂方法获取对象，解耦
 */
public class Client_factory {

    public static void main(String[] args){
        IAccountService accountService = (IAccountService) MyBeanFactoryMulti.getBean("accountService");
        accountService.saveAccount();
    }
}
