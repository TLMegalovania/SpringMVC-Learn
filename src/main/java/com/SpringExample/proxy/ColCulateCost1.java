package com.SpringExample.proxy;

public class ColCulateCost1 {


    public void manageTask(){

        startCalculateCost();

        OldProject1 project = new OldProject1();
        project.doTask();

        endCalculateCost();
    }

    public void startCalculateCost(){
        System.out.println("start to calculate");
    }

    public void endCalculateCost(){
        System.out.println("end calculate");
    }
}
