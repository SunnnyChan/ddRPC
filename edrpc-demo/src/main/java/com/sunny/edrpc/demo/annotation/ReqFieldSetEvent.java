package com.sunny.edrpc.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sunnnychan@gmail.com
 * 表示需要触发事件的方法
 * RPC 是在 Set 请求参数触发，表示某项数据已准备好
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReqFieldSetEvent {

}
