package org.stone.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapred.JobClient; 
import org.apache.hadoop.mapred.JobStatus; 
import org.apache.hadoop.mapred.JobConf; 
import org.apache.hadoop.mapred.JobID; 

import org.stone.model.FileInfo;

public class JobService {

    private JobConf jconf;
    private JobClient jclient;
    private Log log = LogFactory.getLog(JobService.class);

        /*
    public JobService() {
        super();
        this.jconf = new JobConf(new Configuration());
        this.jclient = new JobClient(this.jconf);
    }

    public List<JobID> listJob() throws IOException {
        JobStatus[] js;
        List<JobID> jobs = new ArrayList<JobID>();
        js = jclient.getAllJobs();
        for(int i=0; i<js.length; i++) {
           System.out.println(js[i].getJobID()); 
           jobs.append(js[i].getJobID()); 
        }
        

        return jobs;
    }
        */

}
