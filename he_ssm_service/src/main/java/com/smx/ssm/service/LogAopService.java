package com.smx.ssm.service;

import com.smx.ssm.domain.SysLog;

import java.util.List;

public interface LogAopService {
    //保存日志
    public void saveLog(SysLog sysLog);
    //查找所有日志
    public List<SysLog> findAll(Integer currentPage,Integer pageSize);
}
