package com.SpringExample.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component(value = "aroundAspect")
public class AroundAspect {

    public final static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSSS");

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        long startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
        System.out.println(this.getClass().getName() + " start at:" + new Date());

        try{
            Object[] args = pjp.getArgs();
            result = pjp.proceed(args);
        }catch (Throwable t){
            new Exception("around notice throw an exception");
        }
        finally {
            long endTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间

            String text = sdf.format(new Date(startTimeMillis)) + " - " + sdf.format(new Date(endTimeMillis)) + "\t"
                    + (endTimeMillis - startTimeMillis) / 1000.0 + "s";
            System.out.println(pjp + "耗时:" + text);
            System.out.println(this.getClass().getName() + " end at:" + new Date());
        }
        return result;
    }
}
