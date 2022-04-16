package com.SpringExample.ui.testSpring;

import com.SpringExample.aop.LogAspect;
import com.SpringExample.model.Account;
import com.SpringExample.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxy_jdkDynamic2 {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //被代理对象A
        final  IAccountService accountService = (IAccountService)applicationContext.getBean("accountService5");

        final LogAspect logger = (LogAspect)applicationContext.getBean("loggerAspect");

        //动态代理类对象C
        IAccountService accountServiceAgent = (IAccountService)Proxy.newProxyInstance(IAccountService.class.getClassLoader(), new Class[]{IAccountService.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //logger.printStartLog();

                Object returnVal = method.invoke(accountService, args);
                return returnVal;

                //method.invoke(accountService, args);
                //return null;
            }
        });

        accountServiceAgent.saveAccount();


        Account account = new Account();
        account.setName("Mr Liu");
        account.setMoney(100);

        accountServiceAgent.add(account);

        accountServiceAgent.findAll();

    }
}
