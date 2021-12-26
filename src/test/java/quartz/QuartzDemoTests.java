package quartz;

import org.junit.Test;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import quartz.task.SimpleJob1;

public class QuartzDemoTests {

    @Test
    public void doTest() {
        try {
            // 设置job的名称及分组
            JobDetail jobDetail1 = JobBuilder.newJob(SimpleJob1.class)
                    .withIdentity("SimpleJob1", "SimpleJob1")
                    .usingJobData("jobSays", "Hello World!")
                    .usingJobData("myFloatValue", 3.141f)
                    .build();

            // 声明触发器
            Trigger trigger1 = TriggerBuilder
                    .newTrigger()
                    .withIdentity("SimpleTrigger1", "SimpleJob")
                    .usingJobData("trigger_key", "Time intv: 1-4")
                    .startNow()
                    .withSchedule(
                            SimpleScheduleBuilder
                            .simpleSchedule()
                            .withIntervalInSeconds(3)
                            .repeatForever())
                    .build();

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail1, trigger1);

            scheduler.start();
            Thread.sleep(3 * 1000); // 30s

            scheduler.shutdown();
        } catch (SchedulerException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
