package com.chenhui.crm.settings.web.controller;

import com.chenhui.crm.settings.domain.User;
import com.chenhui.crm.settings.service.UserService;
import com.chenhui.crm.settings.service.impl.UserServiceImpl;
import com.chenhui.crm.utils.MD5Util;
import com.chenhui.crm.utils.PrintJson;
import com.chenhui.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        String path = req.getServletPath();
        String conTextPath = req.getContextPath();
        System.out.println("path-->"+path+"||conTextPath-->"+conTextPath);
        if ("/settings/user/login.do".equals(path)){
            login(req,resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        String ip = req.getRemoteAddr();
        String loginAct = req.getParameter("loginAct");
        String loginPwd = req.getParameter("loginPwd");
        loginPwd = MD5Util.getMD5(loginPwd);
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        try {
            User user = us.login(loginAct,loginPwd,ip);
            req.getSession().setAttribute("user", user);
            PrintJson.printJsonFlag(resp, true);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = e.getMessage();
            System.out.println(msg);
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("success", false);
            paramMap.put("msg", msg);

            PrintJson.printJsonObj(resp, paramMap);
        }


    }
}
