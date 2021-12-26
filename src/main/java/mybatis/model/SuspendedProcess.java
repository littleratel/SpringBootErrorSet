package mybatis.model;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class SuspendedProcess {
    private String scalingGroupId;
    private byte scaleIn;
    private byte scaleOut;
    private byte healthCheck;
    private byte scheduled;
    private byte alarm;
}
