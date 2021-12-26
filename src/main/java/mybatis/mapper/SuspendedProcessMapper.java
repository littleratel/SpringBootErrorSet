package mybatis.mapper;

import mybatis.model.SuspendedProcess;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuspendedProcessMapper {
    List<SuspendedProcess> findAll();
}
