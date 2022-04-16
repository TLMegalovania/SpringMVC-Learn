package com.SpringExample.ui.testHibernate;

import com.SpringExample.hibernate.IProductService;
import com.SpringExample.model.Product;
import com.SpringExample.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Client_SpringHibernateWithAnnotation {


    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IProductService productService = (IProductService)applicationContext.getBean("productService");

        Product newProduct = new Product();
        newProduct.setName("射雕英雄传");
        newProduct.setPrice(10.0);
        newProduct.setFactory("武汉大学出版社");
        newProduct.setRemark("备注");
        productService.save(newProduct);

        List<Product> results = productService.findAll();

        for (Product product: results){
            System.out.println("产品ID："+ product.getId());
            System.out.println("产品名称："+product.getName());
            System.out.println("产品价格："+product.getPrice()+"元");
            System.out.println("生产厂商："+product.getFactory());
            System.out.println("产品备注："+product.getRemark());
        }
    }
}
