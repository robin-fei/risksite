package com.wpt.risk.engine.manage;

import com.wpt.risk.base.exception.AuthenticationException;
import com.wpt.risk.base.exception.UserFoundException;
import com.wpt.risk.base.exception.UserNotFoundException;
import com.wpt.risk.base.utils.ErrorCode;
import com.wpt.risk.dal.pojo.WUser;
import com.wpt.risk.engine.service.UserService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginManager {

    private static final Logger logger = LoggerFactory.getLogger(LoginManager.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public WUser auth(String uname, String passwd) throws UserNotFoundException, AuthenticationException {
        WUser user = userService.findUser(uname);
        if (user == null) {
            throw new UserNotFoundException(ErrorCode.USER_NOT_EXIST_ERROR, "userName: " + uname + " not exist");
        }

        if (!passwordEncoder.matches(passwd, user.getPassword())) {
            logger.error("password is not correct: " + passwd);
            throw new AuthenticationException(ErrorCode.PASSWORD_ERROR, "userName: " + uname + ", raw password: " + passwd);
        }

        return user;
    }

    public void reg(String uname, String passwd) throws UserFoundException {
        WUser user = userService.findUser(uname);
        if (user != null) {
            throw new UserFoundException(ErrorCode.USER_NOT_EXIST_ERROR, "userName: " + uname + " exist");
        }

        String encPass = passwordEncoder.encode(passwd);
        user = new WUser();
        user.setUsername(uname);
        user.setPassword(encPass);
        user.setJoinDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        userService.addUser(user);
    }
}