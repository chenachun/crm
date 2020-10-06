package com.chenhui.crm.web.filter;

import com.chenhui.crm.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName : LoginFilter
 * Package : com.chenhui.crm.web.filter
 * Description :
 *
 * @author : chenhui@xvco.com
 */
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String path = request.getServletPath();

        if ("/login.jsp".equals(path) || "/settings/user/login.do".equals(path)){
            filterChain.doFilter(request, response);
        }else {
            User user = (User)request.getSession().getAttribute("user");
            if (user != null){
                filterChain.doFilter(request, response);
            }else{
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }
    }
}
