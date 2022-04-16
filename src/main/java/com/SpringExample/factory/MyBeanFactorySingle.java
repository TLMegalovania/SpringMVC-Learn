package com.SpringExample.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MyBeanFactorySingle {

    private static Map<String, Object> beans;

    private static Properties properties;


    static {
        try{
            properties = new Properties();
            InputStream in = MyBeanFactoryMulti.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);

            beans = new HashMap<String, Object>();
            Enumeration keys = properties.keys();
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanPath = properties.getProperty(key);
                Object bean = Class.forName(beanPath).newInstance();
                beans.put(key, bean);
            }
        }
        catch (Exception e){
            System.out.println("没有bean.properties文件");
            throw new ExceptionInInitializerError();
            //e.printStackTrace();
        }
    }

    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
}
