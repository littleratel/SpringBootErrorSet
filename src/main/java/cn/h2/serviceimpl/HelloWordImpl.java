package cn.h2.serviceimpl;

import annotation.SaveLog;
import cn.h2.service.HelloWord;
import org.springframework.stereotype.Service;

@Service("helloWord")
public class HelloWordImpl implements HelloWord {

    @SaveLog
    public String say() {
        return "Hello World!";
    }
}
