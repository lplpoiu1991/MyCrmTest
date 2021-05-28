package com.sekai.crm.settings.service.impl;

import com.sekai.crm.exception.LoginException;
import com.sekai.crm.settings.dao.UserDao;
import com.sekai.crm.settings.domain.User;
import com.sekai.crm.settings.service.UserService;
import com.sekai.crm.utils.DateTimeUtil;
import com.sekai.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userdao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);


    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException {

        Map<String, String> map = new HashMap<String,String>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);
        User user = userdao.login(map);
        if (user == null) {
            throw new LoginException("账号密码错误");
        }

        String expireTime = user.getExpireTime();
        String currentTime = DateTimeUtil.getSysTime();
         if (currentTime.compareTo(expireTime)<0){
             throw  new LoginException("账号失效");
         }

        String lockState = user.getLockState();
        if("0".equals(lockState)){

            throw new LoginException("账号已锁定");

        }

        String allowIps = user.getAllowIps();
        //if(allowIps != null && allowIps!="");
        if (!allowIps.contains(ip)) {
            throw  new LoginException("IP受限");
        }
        return user;
    }
}
