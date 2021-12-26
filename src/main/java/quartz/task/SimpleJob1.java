package quartz.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class SimpleJob1 implements Job {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int num = new Random().nextInt(100);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String jobSays = dataMap.getString("jobSays");
        float floatValue = dataMap.getFloat("myFloatValue");
        String triggerSays = dataMap.getString("trigger_key");
        log.info("===> [{}] SimpleJob1: {} Start ... ", num, sdf.format(new Date()));
        log.info("===> JobExecutionContext: {}, {}, {}, {}", key, jobSays, floatValue, triggerSays);

        try {
            ApplicationContext ctx = (ApplicationContext) context.getScheduler().getContext();
            log.info("ApplicationContext: {}", ctx);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("===> [{}] SimpleJob1: {} End!", num, sdf.format(new Date()));
    }
}
