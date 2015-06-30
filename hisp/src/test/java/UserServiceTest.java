package org.stone;  
  
import org.junit.Test;  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.annotation.AnnotationConfigApplicationContext;  
  
import junit.framework.TestCase;  
  
public class UserServiceTest extends TestCase {  
	    @Test  
			    public void testPrintUser() {  
					/*
					        ApplicationContext ctx =   
								                new AnnotationConfigApplicationContext(ApplicationConfig.class);  
							          
							        UserService userService = ctx.getBean(UserService.class);  
									        userService.printUser();  
											*/
											          
											        //用  @Configuration + @Bean 的时候用这个获取bean  
											//      UserService userService = (UserService) ctx.getBean("userService");  
											          
											    }  
}
