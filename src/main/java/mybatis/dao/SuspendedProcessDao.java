package mybatis.dao;

import mybatis.mapper.SuspendedProcessMapper;
import mybatis.model.SuspendedProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SuspendedProcessDao {

    @Autowired
    private SuspendedProcessMapper mapper;

    public List<SuspendedProcess> findAll() {
        return mapper.findAll();
    }
}
