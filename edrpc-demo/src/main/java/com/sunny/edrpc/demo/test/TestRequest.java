package com.sunny.edrpc.demo.test;

import com.sunny.edrpc.demo.annotation.ReqFieldSetEvent;
import com.sunny.edrpc.demo.rpc.EdRpcRequest;
/**
 * @author sunnnychan@gmail.com
 * 业务层的RPC请求数据对象
 */
public class TestRequest implements EdRpcRequest {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    @ReqFieldSetEvent
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @ReqFieldSetEvent
    public void setName(String name) {
        this.name = name;
    }
}
