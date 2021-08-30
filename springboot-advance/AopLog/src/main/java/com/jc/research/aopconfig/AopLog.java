package com.jc.research.aopconfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @program: springboot-combat-faction
 * @description:
 * @author: SunChao
 * @create: 2021-08-29 19:59
 **/
@Aspect
@Component
public class AopLog {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //线程局部变量，用于解决多线程中相同变量的访问冲突问题
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    //定义切点
    @Pointcut("execution(public * com.jc.research..*.*(..))")
    public void aopWebLog() {

    }

    @Before("aopWebLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        //收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录下请求内容
        logger.info("URL: " + request.getRequestURL().toString());
        logger.info("HTTP方法: " + request.getMethod());
        logger.info("IP地址: " + request.getRemoteAddr());
        logger.info("类的方法: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("参数: " + request.getQueryString());
    }

    @AfterReturning(pointcut = "aopWebLog()", returning = "returnObj")
    public void doAfterReturning(Object returnObj) {
        //处理完请求，返回内容
        logger.info("应答值： " + returnObj);
        logger.info("费时：" + (System.currentTimeMillis() - startTime.get()));
    }

    @AfterThrowing(pointcut = "aopWebLog()", throwing = "ex")
    public void addAfterThrowingLogger(JoinPoint joinPoint, Exception ex) {
        logger.error("执行 " + " 异常", ex);
    }
}
