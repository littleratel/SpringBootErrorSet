package mybatis;

import lombok.extern.java.Log;
import mybatis.dao.SuspendedProcessDao;
import mybatis.dao.UserDao;
import mybatis.model.SuspendedProcess;
import mybatis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class MybatisAppTests {
    @Autowired
    private UserDao userDao;

    @Autowired
    private SuspendedProcessDao suspendedProcessDao;

    @Test
    public void userDaoTest() {
        List<User> re = userDao.findAll();
        System.out.println(re.get(0));
    }

    @Test
    public void suspendedProcessDaoTest() {
        List<SuspendedProcess> re = suspendedProcessDao.findAll();
        System.out.println(re.size());
        System.out.println(re.get(0));
    }
}
