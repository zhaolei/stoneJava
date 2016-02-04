package org.stone.te;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;
import org.apache.hadoop.mapred.JobClient; 
import org.apache.hadoop.mapred.JobStatus; 
import org.apache.hadoop.mapred.JobConf; 

import java.io.IOException;

 

public class HdfsFile{

    private Configuration conf;
    private FileSystem hdfs;
    public HdfsFile() throws Exception {
        conf=new Configuration();
        hdfs=FileSystem.get(conf);
    }
    public static void main(String[] args) throws Exception {
        System.out.println("当前程序所在目录：" + System.getProperty("user.dir")); 
        HdfsFile objHdfsFile = new HdfsFile();
        //objHdfsFile.listFile("/");
        objHdfsFile.listJob();

        //本地文件
        //Path src =new Path("D:\\HebutWinOS");
        //HDFS为止
        //Path dst =new Path("/");
        //hdfs.copyFromLocalFile(src, dst);
        //System.out.println("Upload to"+conf.get("fs.default.name"));
        //FileStatus files[]=hdfs.listStatus(dst);
        /*
        for(FileStatus file:files){
            System.out.println(file.getPath());
        }
        */

        /*
        JobStatus[] js;
        //JobClient jobclient = new JobClient();
        JobConf cf = new JobConf(new Configuration());
        JobClient jc = new JobClient(cf);
        //js = JobClient.getAllJobs();
        js = jc.getAllJobs();
        for(int i=0; i<js.length; i++) {
           System.out.println(js[i].getJobID()); 
        }
        */
    }

    public void listJob() throws IOException  {
        JobStatus[] js;
        //JobClient jobclient = new JobClient();
        JobConf cf = new JobConf(new Configuration());
        JobClient jc = new JobClient(cf);
        js = jc.getAllJobs();
        for(int i=0; i<js.length; i++) {
           System.out.println(js[i].getJobID()); 
        }

    }

    public void createFile(String FilePath) throws Exception {
        byte[] buff="hello hadoop world!\n".getBytes(); 
        Path dfs=new Path(FilePath);
        FSDataOutputStream outputStream=hdfs.create(dfs);
        outputStream.write(buff,0,buff.length);
    }

    public void listFile(String FilePath) throws Exception {
        Path dst =new Path(FilePath);
        FileStatus files[]=hdfs.listStatus(dst);

        for(FileStatus file:files){
            System.out.println(file.getPath());
        }
        
    }

    public void listNode() throws Exception {
        DistributedFileSystem hs = (DistributedFileSystem)hdfs;

        DatanodeInfo[] dataNodeStats = hs.getDataNodeStats();

        for(int i=0;i<dataNodeStats.length;i++){
            System.out.println("DataNode_"+i+"_Name:"+dataNodeStats[i].getHostName());
        }

    }

}
