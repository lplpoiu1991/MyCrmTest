package com.sekai.crm.settings.service.impl;

import com.sekai.crm.settings.dao.UserDao;
import com.sekai.crm.settings.service.UserService;
import com.sekai.crm.utils.SqlSessionUtil;

public class UserServiceImpl implements UserService {
    private UserDao userdao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);


}
