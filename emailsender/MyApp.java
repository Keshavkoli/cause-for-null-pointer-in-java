package com.hrc.emailsender;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class MyApp {
	public static void main(String[] args) {
		try {
			JobDetail job1 = JobBuilder.newJob(Job1.class).withIdentity("job1", "group1").build();

			Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("cronTrigger1", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();// the call will trigger every 1 minute
			
			Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
			scheduler1.start();
			scheduler1.scheduleJob(job1, trigger1);
/*
			JobDetail job2 = JobBuilder.newJob(Job2.class).withIdentity("job2", "group2").build();

			Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("cronTrigger2", "group2")
					.withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression("0 0/1 * 1/1 * ? *"))).build();

			Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
			scheduler2.start();
			scheduler2.scheduleJob(job2, trigger2);
*/
//			thread.sleep(10000)
			Thread.sleep(30 * 60 * 1000);// the thread will sleep after 30 minutes

			scheduler1.shutdown();
//			scheduler2.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
