package com.wpt.risk.engine.service;

import com.wpt.risk.dal.dao.WUserMapper;
import com.wpt.risk.dal.pojo.WUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private WUserMapper wUserMapper;

    public WUser findUser(String username) {
        return wUserMapper.selectByUserId(username);
    }

    public int addUser(WUser user) {
        return wUserMapper.insertSelective(user);
    }
}