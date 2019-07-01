package com.sunny.edrpc.demo.rpc;

import com.sunny.edrpc.demo.annotation.ReqFieldSetEvent;
import com.sunny.edrpc.demo.event.Event;
import com.sunny.edrpc.demo.event.RpcEventMgt;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author sunnnychan@gmail.com
 * RPC RequestProxy 代理类
 */
public class RequestProxy<T> implements MethodInterceptor {
    private T target;

    private HashMap<String, Event> methodNameEventMap;

    public RequestProxy(HashMap<String, Event> methodNameEventMap) {
        this.methodNameEventMap = methodNameEventMap;
    }

    public T getInstance(T target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = methodProxy.invokeSuper(proxy, args);
        // ReqFieldSetEvent 注解的方法需要发送 事件ID，表示事件已触发
        if (method.isAnnotationPresent(ReqFieldSetEvent.class)) {
            RpcEventMgt.receive(this.methodNameEventMap.get(method.getName()).getId());
        }
        return result;
    }
}
