package com.javaliu.modules.transaction.service;

import com.javaliu.modules.transaction.entity.User;

public interface IUserService {

    /**
     * 添加用户
     *
     * @param user
     */
    public void addUser(User user);

    /**
     * 修改用户
     *
     * @param user
     */
    public void updateUser(User user);
}
