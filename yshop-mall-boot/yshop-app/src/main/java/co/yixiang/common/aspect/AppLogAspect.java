/**
 * Copyright (C) 2018-2022
 * All rights reserved, Designed By www.yixiang.co

 */
package co.yixiang.common.aspect;

import co.yixiang.common.bean.LocalUser;
import co.yixiang.modules.logging.domain.Log;
import co.yixiang.modules.logging.service.LogService;
import co.yixiang.utils.RequestHolder;
import co.yixiang.utils.StringUtils;
import co.yixiang.utils.ThrowableUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hupeng
 * @date 2018-11-24
 */
@Component
@Aspect
@Slf4j
public class AppLogAspect {

    private final LogService logService;

    ThreadLocal<Long> currentTime = new ThreadLocal<>();

    public AppLogAspect(LogService logService) {
        this.logService = logService;
    }

    /**
     * 配置切入点
     */
    @Pointcut("@annotation(co.yixiang.modules.logging.aop.log.AppLog)")
    public void logPointcut() {
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }

    /**
     * 配置环绕通知,使用在方法logPointcut()上注册的切入点
     *
     * @param joinPoint join point for advice
     */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        currentTime.set(System.currentTimeMillis());
        result = joinPoint.proceed();
        Log log = new Log("INFO",System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        logService.saveApp(getUsername(),
                StringUtils.getIp(RequestHolder.getHttpServletRequest()),joinPoint,
                log,getUid());
        return result;
    }

    /**
     * 配置异常通知
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        Log log = new Log("ERROR",System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        log.setExceptionDetail(ThrowableUtil.getStackTrace(e).getBytes());
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        logService.save(getUsername(),
                StringUtils.getIp(RequestHolder.getHttpServletRequest()),
                (ProceedingJoinPoint)joinPoint, log,getUid());
    }

    public String getUsername() {
        try {
            return LocalUser.getUser().getUsername();
        }catch (Exception e){
            return "";
        }
    }

    public Long getUid(){
        try {
            return LocalUser.getUser().getUid();
        }catch (Exception e){
            return 0L;
        }
    }
}