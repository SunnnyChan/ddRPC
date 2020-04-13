package com.sunny.edrpc.demo.test;

import com.sunny.edrpc.demo.event.EventHandler;
import com.sunny.edrpc.demo.event.RpcEventMgt;
import com.sunny.edrpc.demo.rpc.EdRpc;
import com.sunny.edrpc.demo.rpc.HttpCall;
import org.testng.annotations.Test;

/**
 * @author sunnnychan@gmail.com
 * 测试类
 */
public class TestEdRpc {

    @Test
    public void test() throws Exception {
        // RPC1 请求
        TestRequest testRequest1 = new TestRequest();
        // RPC1 注册
        EventHandler httpCall1 = new HttpCall(testRequest1, null, null);
        EdRpc<TestRequest> edRpc1 = new RpcEventMgt<TestRequest>().register(testRequest1, httpCall1);
        TestRequest testRequestNew1 = edRpc1.getEdRpcRequest();

        // RPC2 请求
        TestRequest testRequest2 = new TestRequest();
        // RPC2 注册
        EventHandler httpCall2 = new HttpCall(testRequest2, null, null);
        EdRpc<TestRequest> edRpc2 = new RpcEventMgt<TestRequest>().register(testRequest2, httpCall2);
        TestRequest testRequestNew2 = edRpc2.getEdRpcRequest();

        // 模拟 请求的组装过程
        testRequestNew2.setName("sunny2");
        testRequestNew1.setId(110);
        Thread.sleep(2000);

        testRequestNew2.setId(111);
        testRequestNew1.setName("sunny1");
        Thread.sleep(2000);

        // 在业务流转到实际需要RPC的地方直接获取结果
        System.out.println("RPC ID : " + edRpc1.getRpcId() + " Result : " + RpcEventMgt.getResult(edRpc1.getRpcId()));
        System.out.println("RPC ID : " + edRpc2.getRpcId() + " Result : " + RpcEventMgt.getResult(edRpc2.getRpcId()));
    }

    @Test
    public void test2() throws Exception {

    }
}
