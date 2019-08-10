package cn.h2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hw")
public class HelloController {

    @ResponseBody
    @RequestMapping("/say")
    public String hello() {
        return "Hello World";
    }
}