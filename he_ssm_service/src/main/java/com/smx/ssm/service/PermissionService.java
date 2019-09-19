package com.smx.ssm.service;

import com.smx.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 查询所有权限
     */
    public List<Permission> findAll(Integer currentPage,Integer pageSize);
    /**
     * 添加权限
     */
    public void savePermission(Permission permission);
}
