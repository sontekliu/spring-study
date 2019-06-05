package com.javaliu.modules.transaction.mapper;

import com.javaliu.common.mapper.BaseMapper;
import com.javaliu.modules.transaction.entity.Log;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper extends BaseMapper<Log> {
}
