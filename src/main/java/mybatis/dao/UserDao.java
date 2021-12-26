package mybatis.dao;

import mybatis.mapper.UserMapper;
import mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public int update(User user) {
        return userMapper.update(user);
    }

    public List<User> getStuById(int id) {
        if (id <= 0) {
            return null;
        }

        return userMapper.getStuById(id);
    }

}
