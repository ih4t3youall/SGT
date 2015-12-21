package ar.com.sgt.batch.scheduler;




import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HistorialTicketScheduler {

    private JobLauncher jobLauncher;

    private Job job;

    public void run() {

      try {

      String dateParam = new Date().toString();
      log.info("starting job");
      JobParameters param = 
        new JobParametersBuilder().addString("date", dateParam).toJobParameters();
              
      log.info(dateParam);
              
      JobExecution execution = jobLauncher.run(job, param);
      log.info("Exit Status : " + execution.getStatus());

        } catch (Exception e) {
            log.error( "exception thrown", e);
        }

    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    public void setJob(Job job) {
        this.job = job;
    }
    
    
    
}
