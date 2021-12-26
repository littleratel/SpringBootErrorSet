package cn.h2.serviceimpl;

import cn.h2.domain.RuleLogTypeRelation;
import cn.h2.repository.RuleTypeRepo;
import cn.h2.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ruleTypeService")
public class RuleTypeServiceImpl implements RuleService<RuleLogTypeRelation> {

    @Autowired
    private RuleTypeRepo repo;

    @Override
    public RuleLogTypeRelation save(RuleLogTypeRelation bean) {
        return repo.save(bean);
    }

    @Override
    public RuleLogTypeRelation findById(String id) {
        return repo.findOneById(id);
    }

    @Override
    public List<RuleLogTypeRelation> findAll() {
        return repo.findAll();
    }

    @Override
    public List<RuleLogTypeRelation> findByLogType(String logType) {
        return repo.findByLogType(logType);
    }

    @Override
    public void delete(RuleLogTypeRelation bean) {
        repo.delete(bean);
    }

}
