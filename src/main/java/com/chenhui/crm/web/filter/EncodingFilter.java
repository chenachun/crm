package com.chenhui.crm.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * ClassName : EncodingFilter
 * Package : com.chenhui.crm.web.filter
 * Description :
 *
 * @author : chenhui@xvco.com
 */
public class EncodingFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
