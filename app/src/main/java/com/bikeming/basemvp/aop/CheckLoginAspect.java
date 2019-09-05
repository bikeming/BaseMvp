package com.bikeming.basemvp.aop;

import android.content.Context;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @ClassName: com.bikeming.basemvp.aop
 * @Description:
 * @author: fjm
 * @date: 2019/9/5 14:29
 * @Version:1.0
 */

@Aspect
public class CheckLoginAspect {

    @Pointcut("execution(@com.bikeming.basemvp.aop.CheckIsLogined * *(..))")
    public void checkLogin() {
    }

    @Around("checkLogin()")
    public void aroundLoginPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        ILogin iLogin = LoginAspectJHelp.getInstance().getiLogin();
        if (iLogin == null) {
            throw new Exception("LoginAspectJHelp not init！");
        }

        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new Exception("annotation_CheckIsLogined can only used at METHOD");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        CheckIsLogined loginFilter = methodSignature.getMethod().getAnnotation(CheckIsLogined.class);
        if (loginFilter == null) {
            return;
        }

        Context applicationContext = LoginAspectJHelp.getInstance().getApplicationContext();

        if (iLogin.isLogin()) {
            joinPoint.proceed();
        } else {
            iLogin.login(applicationContext, loginFilter.loginType());
        }

    }
}
