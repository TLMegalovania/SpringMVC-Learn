package com.SpringExample.ui.testSpring;

import com.SpringExample.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_SpringWithAnnotation {


    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService)applicationContext.getBean("accountService4");
        accountService.saveAccount();
    }
}
