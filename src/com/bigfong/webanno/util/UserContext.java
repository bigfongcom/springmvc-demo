package com.bigfong.webanno.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bigfong.webanno.domain.Employee;


/***********************************************************************   
* 封装当前登陆用户的上下文信息
* @author        bigfong
* @create-time   2018年11月9日 上午10:49:12
* @revision      $Id: 1.0  
*   
***********************************************************************/

public class UserContext {
    public static final String USER_IN_SESSION = "user_in_session";
    
    public static HttpSession getSession() {
        return ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    }
    
    public static void  setCurrentUser(Employee current) {
        if (current == null) {
            getSession().invalidate();            
        }else {            
            getSession().setAttribute(USER_IN_SESSION, current);
        }        
    }
    
    public static Employee getCurrentUser() {
        return (Employee)getSession().getAttribute(USER_IN_SESSION);
    }
}
