package com.bikeming.basemvp.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: com.bikeming.basemvp.aop
 * @Description:
 * @author: fjm
 * @date: 2019/9/5 14:02
 * @Version:1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CheckIsLogined {

    int loginType() default 0;
}
