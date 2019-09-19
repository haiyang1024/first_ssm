package com.smx.ssm.dao;

import com.smx.ssm.domain.SysLog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 日志dao
 */
@Repository
public interface LogAopDao {
    /**
     * 保存日志信息
     * @param sysLog
     */
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "visitTime",column = "visit_time"),
            @Result(property = "username",column = "username"),
            @Result(property = "ip",column = "ip"),
            @Result(property = "url",column = "url"),
            @Result(property = "executionTime",column = "execution_time"),
            @Result(property = "method",column = "method")
    })
    @Insert("insert into sys_log (visit_time,username,ip,url,execution_time,method) values (#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void saveLog(SysLog sysLog);

    /**
     * 查询所有日志信息
     * @return
     */
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "visitTime",column = "visit_time"),
            @Result(property = "username",column = "username"),
            @Result(property = "ip",column = "ip"),
            @Result(property = "url",column = "url"),
            @Result(property = "executionTime",column = "execution_time"),
            @Result(property = "method",column = "method")
    })
    @Select("select * from sys_log")
    public List<SysLog> findAll(Integer currentPage,Integer pageSize);
}
