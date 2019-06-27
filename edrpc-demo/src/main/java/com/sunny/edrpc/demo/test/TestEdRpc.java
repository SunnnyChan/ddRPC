package com.sunny.edrpc.demo.test;

import com.sunny.edrpc.demo.event.EventHandler;
import com.sunny.edrpc.demo.rpc.HttpCall;

public class TestEdRpc {

    public static void main(String[] args) throws Exception {
        // RPC 请求
        TestRequest testRequest = new TestRequest();
        // RPC 事件处理器
        EventHandler httpCall = new HttpCall(testRequest, null, null);
        // 模拟 请求的组装过程
        testRequest.setId(110);
        Thread.sleep(2000);
        testRequest.setName("sunny");
        Thread.sleep(2000);

        // 在业务流转到实际需要RPC的地方直接获取结果
        System.out.println(httpCall.getResult());
    }
}
