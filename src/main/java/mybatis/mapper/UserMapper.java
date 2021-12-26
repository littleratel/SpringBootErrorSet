package mybatis.mapper;

import mybatis.model.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

//@Component
@Mapper
public interface UserMapper {
    // @Select("select * from t_user")
    List<User> findAll();

    int update(User user);

    List<User> getStuById(int id);
}
