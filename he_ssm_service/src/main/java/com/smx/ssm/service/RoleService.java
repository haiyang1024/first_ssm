package com.smx.ssm.service;

import com.smx.ssm.domain.Permission;
import com.smx.ssm.domain.Role;

import java.util.List;

public interface RoleService {
    /**
     * 查询所有角色信息
     * @return
     */
    public List<Role> findAll(Integer currentPage,Integer pageSize);

    /**
     * 添加角色
     */
    public void saveRole(Role role);
    /**
     * 根据roleId 查询所有角色信息
     */
    public Role findById(Long roleId);
    /**
     *根据roleId 查询角色可用的权限
     */
    public List<Permission> findOtherPermission(Long roleId);
    /**
     * 给角色添加权限
     */
    public void addRoleToUser(Long roleId,Long permissionId);
}
