package com.SpringExample.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
public class LogAspectWithAnnotation {
    /*
    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    private ObjectMapper mapper = new ObjectMapper();
    */
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Around("execution(public * com.SpringExample.controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        Object result = null;
        long startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
        System.out.println("start at:" + new Date());

        try{
            Object[] args = pjp.getArgs();
            result = pjp.proceed(args);
        }catch (Throwable t){
            //throw Exception("around notice throw an exception");
        }
        finally {
            long endTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
            System.out.println("start at:" + new Date());

            String text = sdf.format(new Date(startTimeMillis)) + " - " + sdf.format(new Date(endTimeMillis)) + "\t"
                    + (endTimeMillis - startTimeMillis) / 1000.0 + "s";
            System.out.println("耗时:" + text);
        }
        return result;
        /*
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        // 获取输入参数
        Map<?, ?> inputParamMap = request.getParameterMap();
        // 获取请求地址
        String requestPath = request.getRequestURI();

        Object principal = SecurityUtils.getSubject().getPrincipal();

        logger.info("[{}] {}, user:{}, request:{}",
                sdf.format(startTimeMillis), requestPath, principal,
                mapper.writeValueAsString(inputParamMap));

        return pjp.proceed();
        */
    }
}
