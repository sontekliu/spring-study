package com.javaliu.modules.transaction.service.impl;

import com.javaliu.modules.transaction.entity.Log;
import com.javaliu.modules.transaction.service.ILogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements ILogService {

    private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Autowired
    private ILogService logService;

    @Override
    public void addLog(Log log) {
        logService.addLog(log);
    }
}
