package com.lk.demo.netty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
@Controller
@RequestMapping(value = "/geek")
public class TestController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String test(){
        return "hello Get";
    }
    @RequestMapping(value = "/helloPost",method = RequestMethod.POST)
    public String post(){
        return "hello Post";
    }
}
