package cn.h2.controller;

import cn.h2.service.HelloWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hw")
public class HelloController {

    @Autowired
    private HelloWord helloWord;

    @ResponseBody
    @RequestMapping("/say")
    public String hello() {
        return helloWord.say();
    }
}