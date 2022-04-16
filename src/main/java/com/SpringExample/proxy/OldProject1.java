package com.SpringExample.proxy;

public class OldProject1 {

    public void management(){

        startCalculateCost();

        doTask();

        endCalculateCost();
    }

    public void doTask(){
        int num1 = 3;
        int num2 = 2;
        System.out.println("the result is:" + num1 / num2);
    }

    private void startCalculateCost(){
        System.out.println("start to calculate");
    }

    private void endCalculateCost(){
        System.out.println("end calculate");
    }
}
