package com.sekai.crm.settings.dao;

import com.sekai.crm.settings.domain.User;

import java.util.HashMap;

public interface UserDao {
    User login(HashMap<String, String> map);
}
