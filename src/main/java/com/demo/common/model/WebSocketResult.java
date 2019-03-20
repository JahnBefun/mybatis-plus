package com.demo.common.model;


/**
 * websocket结果
 *
 * @author zbf
 * @create 2019-01-17 10:45
 **/
public class WebSocketResult {
    private Integer type;
    private Object data;
    private String queryId;

    public WebSocketResult(Integer type, Object data, String queryId) {
        this.type = type;
        this.data = data;
        this.queryId = queryId;
    }

    public WebSocketResult() {
    }

    public static WebSocketResult succ(Integer type, Object data,String queryId) {
        return new WebSocketResult(type, data,  queryId);
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }
}
