package com.chenhui.crm.settings.service.impl;

import com.chenhui.crm.settings.dao.UserDao;
import com.chenhui.crm.settings.domain.User;
import com.chenhui.crm.settings.exception.LoginException;
import com.chenhui.crm.settings.service.UserService;
import com.chenhui.crm.utils.DateTimeUtil;
import com.chenhui.crm.utils.SqlSessionUtil;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName : UserServiceImpl
 * Package : com.chenhui.crm.settings.service.impl
 * Description :
 *
 * @author : chenhui@xvco.com
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    public User login(String loginAct, String loginPwd, String ip) throws LoginException {
        Map<String,String> map = new HashMap<String, String>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);

        User user = userDao.login(map);
        if (user == null){
            throw new LoginException("用户不存在");
        }

        if (user.getLockState().equals("1")){
            throw new LoginException("访问用户被锁定");
        }

        boolean flag = user.getAllowIps().contains(ip);
        if (!flag){
            throw new LoginException("访问用户IP受限");
        }

        String expirTime = DateTimeUtil.getSysTime();
        if (expirTime.compareTo(user.getExpireTime())>0){
            throw new LoginException("访问用户账户时间过期");
        }

        return user;
    }
}
