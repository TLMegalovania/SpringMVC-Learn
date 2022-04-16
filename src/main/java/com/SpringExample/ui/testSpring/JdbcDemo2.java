package com.SpringExample.ui.testSpring;

import com.SpringExample.configuration.JdbcConfig;
import com.SpringExample.model.Account;
import com.SpringExample.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class JdbcDemo2 {

    public static void main(String[] args) throws SQLException {
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService)applicationContext.getBean("accountService5");
        accountService.saveAccount();

        List<Account> results = accountService.findAll();
        System.out.println("find all");
        for (int i=0; i < results.size(); i++){
            System.out.println(results.get(i).getId() + "\t" + results.get(i).getName() + "\t" + results.get(i).getMoney());
        }
        results = accountService.findByName("z");
        System.out.println("find by name:" + "z");
        for (int i=0; i < results.size(); i++){
            System.out.println(results.get(i).getId() + "\t" + results.get(i).getName() + "\t" + results.get(i).getMoney());
        }

    }
}
