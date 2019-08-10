package cn.h2.controller;

import cn.h2.domain.RuleLogTypeRelation;
import cn.h2.service.RuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rule")
public class H2Controller {

    @Resource(name = "ruleTypeService")
    RuleService<RuleLogTypeRelation> service;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public RuleLogTypeRelation getRuleById(@RequestParam("id") String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<RuleLogTypeRelation> getRuleById() {
        return service.findAll();
    }

}
