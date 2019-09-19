package com.smx.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.smx.ssm.dao.RoleDao;
import com.smx.ssm.domain.Permission;
import com.smx.ssm.domain.Role;
import com.smx.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll(Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        return roleDao.findAll(currentPage,pageSize);
    }

    /**
     * 添加角色
     */
    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public Role findById(Long roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermission(Long roleId) {
        return roleDao.findOtherPermission(roleId);
    }

    @Override
    public void addRoleToUser(Long roleId, Long permissionId) {
        roleDao.addRoleToUser(roleId,permissionId);
    }
}
