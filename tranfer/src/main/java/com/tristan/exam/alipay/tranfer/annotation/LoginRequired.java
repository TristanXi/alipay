package com.tristan.exam.alipay.tranfer.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: alipay
 * @description: 在需要登录验证的Controller的方法上使用此注解
 * @author: Tristan.Xi
 * @create: 2020-06-30 19:07
 **/

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {
}
