package com.SpringExample.proxy;

public class NewProject1 implements  ProjectInterface{

    public void doTask() {
        int num1 = 3;
        int num2 = 2;
        System.out.println("the result is:" + num1 / num2);
    }
}
