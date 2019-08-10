package cn.h2.service;

import java.util.ArrayList;
import java.util.List;

public interface RuleService<T> {

    T save(T bean);

    T findById(String id);

    List<T> findAll();

    void delete(T bean);

    default List<T> findByLogType(String logType) {
        return new ArrayList<>();
    }

}
