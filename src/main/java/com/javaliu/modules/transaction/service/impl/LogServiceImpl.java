package com.javaliu.modules.transaction.service.impl;

import com.javaliu.modules.transaction.entity.Log;
import com.javaliu.modules.transaction.mapper.LogMapper;
import com.javaliu.modules.transaction.service.ILogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogServiceImpl implements ILogService {

    private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Autowired
    private LogMapper logMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addLog(Log log) {
        logMapper.insertOne(log);
    }
}
