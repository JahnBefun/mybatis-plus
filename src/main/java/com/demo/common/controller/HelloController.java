package com.demo.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.common.model.ComInput;
import com.demo.common.util.JsonUtil;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableAutoConfiguration
public class HelloController {
    @RequestMapping("/hello")
    private String index(){
        return "Hello World!";
    }
    @RequestMapping("/comInput")
    private String comInput(@RequestBody ComInput comInput){
        System.out.println(comInput);
        return "Hello comInput!";
    }
    @RequestMapping("/jsonInput")
    private String jsonInput(@RequestBody JSONObject jsonInput){
        ComInput comInput = JsonUtil.deserialize(jsonInput.toJSONString(),ComInput.class);
        System.out.println(jsonInput);
        return "Hello jsonInput!";
    }
    @RequestMapping("/getIp")
    private String jsonInput(HttpServletRequest request){
        String ip = getIpAddress(request);
        System.out.println(ip);
        return "Hello jsonInput!";
    }
    public  String getIpAddress(HttpServletRequest request){
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}
