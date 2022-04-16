package com.SpringExample.ui.testSpring;

import com.SpringExample.model.Account;
import com.SpringExample.model.Book;
import com.SpringExample.service.IAccountService;
import com.SpringExample.service.IBookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class JdbcDemo3 {

    public static void main(String[] args) throws SQLException {
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IBookService bookService = (IBookService)applicationContext.getBean("bookService1");


        List<Book> results = bookService.findAll();
        System.out.println("find all");
        if (results!=null) {
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i).getIsbn() + "\t" +
                        results.get(i).getSm() + "\t" +
                        results.get(i).getLb() + "\t" +
                        results.get(i).getDj() + "\t" +
                        results.get(i).getCbrq());
            }
        }

        results = bookService.findByName("数学");
        System.out.println("find by name:" + "数学");
        if (results!=null) {
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i).getIsbn() + "\t" +
                        results.get(i).getSm() + "\t" +
                        results.get(i).getLb() + "\t" +
                        results.get(i).getDj() + "\t" +
                        results.get(i).getCbrq());
            }
        }

    }
}
