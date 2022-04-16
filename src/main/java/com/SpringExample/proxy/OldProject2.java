package com.SpringExample.proxy;

public class OldProject2 {

    public void management(){

        startCalculateCost();

        doTask();

        endCalculateCost();
    }

    public void doTask(){

        System.out.println("this is my job in project 2");
    }

    private void startCalculateCost(){
        System.out.println("start to calculate");
    }

    private void endCalculateCost(){
        System.out.println("end calculate");
    }
}
