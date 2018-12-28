package com.javaliu.modules.transaction.service.impl;

import com.javaliu.modules.transaction.entity.Log;
import com.javaliu.modules.transaction.entity.User;
import com.javaliu.modules.transaction.mapper.UserMapper;
import com.javaliu.modules.transaction.service.ILogService;
import com.javaliu.modules.transaction.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ILogService logService;

    @Override
    @Transactional
    public void addUser(User user) {
        userMapper.insertOne(user);
        Log log = new Log();
        log.setType("1");
        log.setDetail("add User");
        User user1 = new User();
        user1.setId(20);
        user1.setCode("lisi");
        user1.setName("李四");
        this.updateUser(user1);
        logService.addLog(log);
        //System.out.println(1/0);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userMapper.update(user);
    }
}
