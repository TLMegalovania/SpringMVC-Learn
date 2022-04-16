package com.SpringExample.ui.testSpring;

import com.SpringExample.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_SpringWithXml {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService3_1 = (IAccountService)applicationContext.getBean("accountService3_1");
        accountService3_1.saveAccount();

        IAccountService accountService3_2 = (IAccountService)applicationContext.getBean("accountService3_2");
        accountService3_2.saveAccount();
    }
}
