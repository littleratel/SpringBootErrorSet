package cn.h2.repository;

import cn.h2.domain.Rule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepo extends CrudRepository<Rule, String> {

    @Query(value = "FROM Rule where id = ?1")
    Rule findRuleById(String id);

}
