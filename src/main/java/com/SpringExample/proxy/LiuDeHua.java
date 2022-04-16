package com.SpringExample.proxy;

/*
明星实现类“刘德华”：
*/
public class LiuDeHua implements Star {

    public String sing(String name) {
        //System.out.println("给我一杯忘情水");
        System.out.println(name);
        return "唱完" ;
    }

    public String dance(String name) {
        //System.out.println("开心的马骝");
        System.out.println(name);
        return "跳完" ;
    }
}
