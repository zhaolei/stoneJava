package org.stone;  
  
import org.springframework.context.annotation.ComponentScan;  
import org.springframework.context.annotation.Configuration;  
  
@Configuration//表明这是一个配置文件，相当于applicationContext.xml  
@ComponentScan//自动扫描  
public class ApplicationConfig {  
	  
	      
	    //下面部分对于这个测试是不需要的。  
	    //只是记录一下 @Configuration + @Bean 的使用  
	    //相当于xml的<bean id=userService class=xxx />  
	    /* 
		       @Bean 
			       public UserService userService() { 
				           return new UserService(); 
						       } 
							       */  
	      
} 
