package com.SpringExample.aop;

import org.springframework.stereotype.Component;

@Component(value = "loggerAspect")
public class LogAspect {

    public void printStartLog(){
        System.out.println(this.getClass().getName() + " 记录开始...");
    }

    public void printEndLog(){
        System.out.println(this.getClass().getName() + " 记录结束...");
    }
}
