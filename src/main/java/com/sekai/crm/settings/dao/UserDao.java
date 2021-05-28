package com.sekai.crm.settings.dao;

import com.sekai.crm.settings.domain.User;

import java.util.Map;

public interface UserDao {
    User login(Map<String, String> map);
}
