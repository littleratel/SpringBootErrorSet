package cn.h2.serviceimpl;

import cn.h2.domain.Rule;
import cn.h2.repository.RuleRepo;
import cn.h2.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ruleService")
public class RuleServiceImpl implements RuleService<Rule> {

    @Autowired
    private RuleRepo ruleRepo;

    @Override
    public Rule save(Rule bean) {
         return ruleRepo.save(bean);
    }

    @Override
    public Rule findById(String id) {
        return ruleRepo.findRuleById(id);
    }

    @Override
    public List<Rule> findAll() {
        List<Rule> result = new ArrayList<>();
        ruleRepo.findAll().forEach(result::add);

        return result;
    }

    @Override
    public void delete(Rule bean) {
        ruleRepo.delete(bean);
    }

}
