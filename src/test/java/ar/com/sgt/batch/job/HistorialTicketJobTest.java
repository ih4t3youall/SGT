package ar.com.sgt.batch.job;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:test-context.xml"
        })
public class HistorialTicketJobTest {
    
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;


    @Test
    public void testJob() throws Exception {
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        Assert.assertEquals("COMPLETED",  jobExecution.getExitStatus());
    }
    
    

}
