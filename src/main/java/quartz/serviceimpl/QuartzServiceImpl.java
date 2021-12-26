package quartz.serviceimpl;

import lombok.extern.slf4j.Slf4j;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quartz.service.QuartzService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service("timeWord")
public class QuartzServiceImpl implements QuartzService {

    @Autowired
    private Scheduler scheduler;

    @Override
    public String doScheduler() {
        String time = new SimpleDateFormat("HH-mm-ss").format(new Date());
        return "Current Time: " + time;
    }

    @Override
    public void addJobs(Class clazz, String name, String group, String cron, Object data) {
        JobDataMap jobDataMap = new JobDataMap();
        if (data != null) {
//            jobDataMap = JSON.parseObject(JSON.toJSONString(data), JobDataMap.class);
        }

        log.error("定时任务开始创建 名称：{} cron表达式：{}", name, cron);
        JobDetail jobDetail = JobBuilder.newJob(clazz)
                /**添加认证信息，有3种重写的方法，我这里是其中一种，可以查看源码看其余2种*/
                .withIdentity(name, group)
                .build();//执行

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .usingJobData(jobDataMap)
                /**添加认证信息，有3种重写的方法，我这里是其中一种，可以查看源码看其余2种*/
                .withIdentity(name, group)
                /**立即生效*/
                .startNow()
                /**添加执行规则，SimpleTrigger、CronTrigger的区别主要就在这里,我这里是demo，写了个每2分钟执行一次*/
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();//执行
        try {
            scheduler.scheduleJob(jobDetail, trigger);
            log.error("定时任务创建成功 名称：{} cron表达式：{}", name, cron);
        } catch (SchedulerException e) {
            log.error("定时任务错误 名称：{} cron表达式：{}", name, cron);
            e.printStackTrace();
        }
    }

    @Override
    public void deleteJobs(String name, String group) {
        log.error("定时任务开始删除 名称：{} 组：{}", name, group);
        JobKey jobKey = new JobKey(name, group);
        try {
            if (scheduler.checkExists(jobKey)) {
                scheduler.deleteJob(jobKey);
                log.error("定时任务删除成功 名称：{} 组：{}", name, group);
            }
        } catch (SchedulerException e) {
            log.error("定时任务删除错误 名称：{} 组：{}", name, group);
            e.printStackTrace();
        }
    }

    @Override
    public void updateJobs(Class classes, String name, String group, String cron, Object data) {
        //删除原来的
        deleteJobs(name, group);

        //新增
        addJobs(classes, name, group, cron, data);
    }

}
