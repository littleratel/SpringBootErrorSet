package mybatis.model;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class User {
    private int id;
    private String uid;
    private String name;
    private String sex;

    private SuspendedProcess suspendedProcess;
}
