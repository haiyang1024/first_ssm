package com.smx.ssm.service;

import com.smx.ssm.domain.Role;
import com.smx.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface UserService extends UserDetailsService {
    /**
     * 查询所有用户
     * @return
     */
    public List<UserInfo> findAll(Integer currentPage,Integer pageSize);
    /**
     * 保存用户
     * @return
     */
    public void saveUser(UserInfo userInfo);
    /**
     * 根据userId查询用户权限和角色(详细信息)
     */
    public UserInfo findByUserId(Long userId);
    /**
     * 根据用户id查询该用户没有的角色
     */
    public List<Role> findUserByIdAndAllRole(Long userId);
    /**
     * 给用户添加角色
     */
    public void addRoleToUser(Long userId,Long roleId);
}
