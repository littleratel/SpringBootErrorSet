package quartz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quartz.service.QuartzService;


@RestController
@RequestMapping("/time")
public class QuartzController {

    @Autowired
    private QuartzService service;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTask() {



        return "";
    }

}
