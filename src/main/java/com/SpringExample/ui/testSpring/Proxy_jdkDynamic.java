package com.SpringExample.ui.testSpring;

import com.SpringExample.proxy.LiuDeHua;
import com.SpringExample.proxy.Star;
import com.SpringExample.proxy.StarProxy;

public class Proxy_jdkDynamic {

    public static void main(String[] args){
        //被代理对象A
        Star ldh = new LiuDeHua();

        //代理类对象B
        StarProxy proxy = new StarProxy();
        proxy.setTarget(ldh);

        //动态代理类对象C
        Object obj = proxy.CreatProxyedObj();

        //转换为被对象代理同类型对象
        Star star = (Star)obj;

        //调用
        star.sing("笨小孩");
        star.dance("饿狼传说");

    }
}
