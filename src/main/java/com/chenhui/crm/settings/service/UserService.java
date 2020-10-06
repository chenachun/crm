package com.chenhui.crm.settings.service;

import com.chenhui.crm.settings.domain.User;
import com.chenhui.crm.settings.exception.LoginException;

/**
 * ClassName : UserService
 * Package : com.chenhui.crm.settings.service
 * Description :
 *
 * @author : chenhui@xvco.com
 */
public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
