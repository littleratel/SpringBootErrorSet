package quartz.service;

public interface QuartzService {

    String doScheduler();

    void addJobs(Class clazz, String name, String group, String cron, Object data);

    void deleteJobs(String name, String group);

    void updateJobs(Class classes, String name, String group, String cron, Object data);
}
