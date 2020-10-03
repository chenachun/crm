package com.chenhui.crm.settings.service.impl;

import com.chenhui.crm.settings.dao.UserDao;
import com.chenhui.crm.settings.service.UserService;
import com.chenhui.crm.utils.SqlSessionUtil;

/**
 * ClassName : UserServiceImpl
 * Package : com.chenhui.crm.settings.service.impl
 * Description :
 *
 * @author : chenhui@xvco.com
 * @date : 2020/10/3 21:04
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

}
