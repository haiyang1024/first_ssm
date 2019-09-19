package com.smx.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.smx.ssm.dao.LogAopDao;
import com.smx.ssm.domain.SysLog;
import com.smx.ssm.service.LogAopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogAopServiceImpl implements LogAopService {
    @Autowired
    private LogAopDao logAopDao;
    @Override
    public void saveLog(SysLog sysLog) {
        logAopDao.saveLog(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer currentPage,Integer pageSize) {
        String orderBy=" visit_time DESC";
        PageHelper.startPage(currentPage,pageSize,orderBy);//使用mybatis自己的分页插件
        return logAopDao.findAll(currentPage, pageSize);
    }
}
