package com.chenhui.crm.settings.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName : UserController
 * Package : com.chenhui.crm.settings.web.controller
 * Description :
 *
 * @author : chenhui@xvco.com
 */
public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入到用户模块");
        String contextPath = req.getContextPath();
        if ("/settings/user/login.do".equals(contextPath)){

        }
    }
}
