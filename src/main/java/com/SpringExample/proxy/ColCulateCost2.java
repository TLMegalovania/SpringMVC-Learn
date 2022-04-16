package com.SpringExample.proxy;

public class ColCulateCost2 {


    public void manageTask(){

        startCalculateCost();

        ProjectInterface project = new NewProject1();
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
