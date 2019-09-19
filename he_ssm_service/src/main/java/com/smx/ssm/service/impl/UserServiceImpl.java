package com.smx.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.smx.ssm.dao.UserDao;
import com.smx.ssm.domain.Role;
import com.smx.ssm.domain.UserInfo;
import com.smx.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *  登录交给springSecurity来管理
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
            userInfo= userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return new User("{noop}"+userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        return new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthority(userInfo.getRoles()));//传入权限认证list<SimpleGrantedAuthority>
    }
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));//把对象中的角色添加进去
        }
        return list;
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<UserInfo> findAll(Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        return userDao.findAll(currentPage,pageSize);
    }
    /**
     * 保存用户
     * @return
     */
    @Override
    public void saveUser(UserInfo userInfo) {
        //对密码进行加密
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.saveUser(userInfo);
    }

    /**
     * 根据userId查询用户权限和角色(详细信息)
     * @param userId
     * @return
     */
    @Override
    public UserInfo findByUserId(Long userId) {
        return userDao.findByUserId(userId);
    }

    /**
     * 给用户添加角色
     * @param userId
     * @return
     */
    @Override
    public List<Role> findUserByIdAndAllRole(Long userId) {
        return userDao.findUserByIdAndAllRole(userId);
    }

    @Override
    public void addRoleToUser(Long userId, Long roleId) {
        userDao.addRoleToUser(userId,roleId);
    }


}
