package com.sekai.crm.settings.web.controller;

import com.sekai.crm.settings.domain.User;
import com.sekai.crm.settings.service.UserService;
import com.sekai.crm.settings.service.impl.UserServiceImpl;
import com.sekai.crm.utils.MD5Util;
import com.sekai.crm.utils.PrintJson;
import com.sekai.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到用户控制器");
        String path = request.getServletPath();
        if ("/settings/user/login.do".equals(path)) {
            login(request, response);

        } else if ("/settings/user.xxx.do".equals(path)) {
            //  xxx(request,response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入登录验证");
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        String ip = request.getRemoteAddr();
        loginPwd = MD5Util.getMD5(loginPwd);
        System.out.println("-----------ip:" + ip);
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        try {
            System.out.println("进入111");
            User user = us.login(loginAct, loginPwd, ip);
            request.getSession().setAttribute("user", user);
            PrintJson.printJsonFlag(response,true);

        } catch (Exception e) {
            e.printStackTrace();
            String msg =e.getMessage();
            HashMap<String, Object> map = new HashMap<>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(response,map);

        }

    }
}
