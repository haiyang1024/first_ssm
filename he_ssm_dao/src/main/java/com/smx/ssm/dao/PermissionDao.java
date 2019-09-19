package com.smx.ssm.dao;

import com.smx.ssm.domain.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionDao {
    /**
     * 根据roleId查询权限
     */
    @Results(id = "permissionMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "permissionName",column = "permission_name"),
            @Result(property = "url",column = "url")
    })
    @Select("select * from permission where id in (select permission_id from role_permission where role_id=#{roleId})")
    public List<Permission> findByRoleId(Long roleId);
    /**
     * 查询所有权限
     */
    @ResultMap("permissionMap")
    @Select("select * from permission ")
    public List<Permission> findAll(Integer currentPage,Integer pageSize);
    /**
     * 添加权限
     */
    @ResultMap("permissionMap")
    @Insert("insert into permission (permission_name,url) values(#{permissionName},#{url})")
    public void savePermission(Permission permission);
}
