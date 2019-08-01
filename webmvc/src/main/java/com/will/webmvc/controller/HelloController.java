package com.will.webmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/index")
    public String index(){
        return "Hello,World!";
    }

    /**
     * 处理页面无法找到的情况
     * @param status
     * @param request
     * @param throwable
     * @return
     */
    @GetMapping("/404.html")
    public Object handlerPageNotFound(HttpStatus status, HttpServletRequest request, Throwable throwable){
        Map<String, Object> errors = new HashMap<>();
        errors.put("statusCode", request.getAttribute("javax.servlet.error.status_code"));
        errors.put("requestURL", request.getAttribute("javax.servlet.error.request_url"));
        return errors;
    }

}
