package com.javaliu.modules.transaction.service;

import com.javaliu.modules.transaction.entity.Log;

public interface ILogService {

    /**
     * 添加日志
     * @param log
     */
    public void addLog(Log log);
}
