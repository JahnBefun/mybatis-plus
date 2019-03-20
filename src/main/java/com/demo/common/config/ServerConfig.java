package com.demo.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ServerConfig {

    @Value("${server.port}")
    private Integer serverPort;

    public String getIp(){
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return address.getHostAddress();
    }
    public String getUrl() {
        return "http://"+ getIp() +":"+getPort();
    }

    public Integer getPort(){
         return serverPort;
    }

}
