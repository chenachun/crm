package com.chenhui.crm.settings.dao;

import com.chenhui.crm.settings.domain.User;

import java.util.Map;

/**
 * ClassName : UserDao
 * Package : com.chenhui.crm.settings.dao
 * Description :
 *
 * @author : chenhui@xvco.com
 */
public interface UserDao {
    User login(Map<String, String> map);
}
