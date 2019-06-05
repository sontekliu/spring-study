package com.javaliu.modules.transaction.mapper;

import com.javaliu.common.mapper.BaseMapper;
import com.javaliu.modules.transaction.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
