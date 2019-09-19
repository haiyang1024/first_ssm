package com.smx.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.smx.ssm.dao.PermissionDao;
import com.smx.ssm.domain.Permission;
import com.smx.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll(Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        return permissionDao.findAll(currentPage,pageSize);
    }

    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }


}
