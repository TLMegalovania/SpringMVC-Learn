package com.SpringExample.factory;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class MyBeanFactoryMulti {

    private static Properties properties;

    static {
        try{
            properties = new Properties();
            InputStream in = MyBeanFactoryMulti.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);
        }
        catch (Exception e){
            System.out.println("没有bean.properties文件");
            throw new ExceptionInInitializerError();
            //e.printStackTrace();
        }
    }
    public static Object getBean(String beanName){
        Object bean = null;
        try{
            String beanPath = properties.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return bean;
    }
}
