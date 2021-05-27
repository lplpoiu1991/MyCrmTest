package com.sekai.crm.settings.service;

import com.sekai.crm.exception.LoginException;
import com.sekai.crm.settings.domain.User;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
