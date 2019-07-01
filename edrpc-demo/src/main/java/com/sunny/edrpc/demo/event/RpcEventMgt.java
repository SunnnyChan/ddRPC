package com.sunny.edrpc.demo.event;

import com.sunny.edrpc.demo.annotation.ReqFieldSetEvent;
import com.sunny.edrpc.demo.rpc.EdRpc;
import com.sunny.edrpc.demo.rpc.RequestProxy;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author sunnnychan@gmail.com
 * 事件管理器
 */
public class RpcEventMgt<T> {
    //存储所有的事件，Key 为事件ID
    private static HashMap<String, Event> events = new HashMap<>();
    //存储事件处理结果，Key 是事件组ID
    private static HashMap<String, String> results = new HashMap<>();

    /**
     * 注册RPC事件
     */
    public EdRpc register(T rpcRequest, EventHandler handler) {
        // 新建事件组
        EventGroup eventGroup = new EventGroup(handler);

        Class c = rpcRequest.getClass();
        Method[] methods = c.getDeclaredMethods();
        HashMap<String, Event> methodNameEventMap = new HashMap<>();
        // 遍历所有的 Request 方法
        for (Method method : methods) {
            if (!method.isAnnotationPresent(ReqFieldSetEvent.class)) {
                continue;
            }
            // 如果有 ReqFieldSetEvent 注解标识，则创建对应的事件
            EventImplement event = new EventImplement("Event-" + c.getName() + "-" + method.getName());
            event.setEventStatus(EventStatus.REGISTERED);
            event.setEventGroup(eventGroup);
            // 保持方法与事件的映射，以在方法执行时，通知事件触发
            methodNameEventMap.put(method.getName(), event);
            // 保存事件状态
            events.put(event.getId(), event);
            // 事件组中加入该事件
            eventGroup.addEvent(event);
        }
        // 返回给业务代码的对象，包含 Request ID（实际是事件组ID） 和 Request 的代理类，后续的 Request 方法调用都通过代理类
        EdRpc edRpc = new EdRpc<T>();
        edRpc.setRpcId(eventGroup.getId());
        edRpc.setEdRpcRequest(rpcRequest);
        // 如果注册了事件，就需要 代理 Request 类
        if (!methodNameEventMap.isEmpty()) {
            edRpc.setEdRpcRequest((T) new RequestProxy<T>(methodNameEventMap).getInstance(rpcRequest));
        }
        System.out.println("RPC ID : " + edRpc.getRpcId());
        return edRpc;
    }

    // 接收到事件触发消息，遍历响应的事件组，判断是否执行事件处理程序
    public static void receive(String eventId) {
        Event event = events.get(eventId);
        event.setEventStatus(EventStatus.READY);
        System.out.println("event generate , ID : " + event.getId() + " name : " + event.getName());
        EventGroup eventGroup = event.getEventGroup();
        // 遍历相应的事件组的所有事件
        for (Event event1 : eventGroup.getEvents()) {
            if (!event1.getEventStatus().equals(EventStatus.READY)) {
                return;
            }
        }
        // 事件组所有事件均已触发，执行事件处理程序
        System.out.println("exec RPC , RPC ID : " + eventGroup.getId());
        // 保持事件处理结果
        results.put(eventGroup.getId(), eventGroup.getEventHandler().handle());
    }

    // 获取事件处理结果
    public static String getResult(String eventGroupId) {
        return results.get(eventGroupId);
    }
}
