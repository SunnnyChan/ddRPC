package com.sunny.edrpc.demo.event;

public enum EventStatus {

    CREATED("0", "已创建"), REGISTERED("1", "已注册"), READY("2", "已发生"), HANDLED("3", "已处理");

    private String desc;
    private String value;

    private EventStatus(String value, String desc) {
        this.desc = desc;
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
