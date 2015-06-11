package org.stone;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Component;  
  
@Component  
public class UserService {  
	      
	    //用@Autowired注解的属性不需要写set/get方法  
	    @Autowired  
			    private UserDAO userDAO;  
		      
		    public void printUser() {  
				        User user = userDAO.getUser();  
						        System.out.println(user.getName());  
								    }  
			      
} 
