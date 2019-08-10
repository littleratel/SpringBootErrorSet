package cn.h2.repository;

import cn.h2.domain.RuleLogTypeRelation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface RuleTypeRepo extends CrudRepository<RuleLogTypeRelation, String> {

    @Query(value = "FROM RuleLogTypeRelation where id = ?1")
    RuleLogTypeRelation findOneById(String id);

    @Query(value = "from RuleLogTypeRelation where logType= ?1 ORDER BY createDate DESC")
    List<RuleLogTypeRelation> findByLogType(String logType);

    @Query(value = "from RuleLogTypeRelation ORDER BY createDate DESC")
    List<RuleLogTypeRelation> findAll();

    @Transactional
    @Modifying
    @Query(value = "insert into RULE_LOG_TYPE_RELATION(ID,LOG_TYPE,ACTION_NAME,CREATE_DATE,RULE) values(?1,?2,?3,?4,?5)", nativeQuery = true)
    void saveAllFields(String id, String logType, String actionName, Date createDate, String ruleid);
}