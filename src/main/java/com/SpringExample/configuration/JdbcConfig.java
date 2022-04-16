package com.SpringExample.configuration;

import com.sun.org.apache.xpath.internal.functions.FuncQname;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.SpringExample")
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {

    @Value("mysql.driver")
    private String driver;

    @Value("mysql.url")
    private String url;

    @Value("mysql.username")
    private String username;

    @Value("mysql.password")
    private String password;
}
