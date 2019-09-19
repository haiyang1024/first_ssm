package com.smx.ssm.dao;

import com.smx.ssm.domain.Role;
import com.smx.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends UserDetails {
    /**
     * 根据用户名查找用户信息包括角色信息
     * @param username
     * @return
     */
    @Results(id = "userMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phone_num"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.smx.ssm.dao.RoleDao.findByRoleId"))
    })
    @Select("select * from users where username=#{username}")
    public UserInfo findByUsername(String username);

    /**
     * 查找所有用户
     * @return
     */
    @ResultMap("userMap")
    @Select("select * from users ")
    public List<UserInfo> findAll(Integer currentPage,Integer pageSize);

    /**
     * 保存用户信息
     * @param userInfo
     */
    @ResultMap("userMap")
    @Insert("insert into users (email,username,password,phone_num,status) values (#{email},#{username},#{password},#{phoneNum},#{status})")
    public void saveUser(UserInfo userInfo);

    /**
     * 根据用户id查询角色和权限
     */
    @ResultMap("userMap")
    @Select("select * from users where id=#{userId}")
    public UserInfo findByUserId(Long userId);
    /**
     * 根据用户id查询该用户没有的角色
     */

    @Select("select * from role where id not in (select role_id from users_role where user_id =#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "role_name"),
            @Result(property = "roleDesc",column = "role_desc")
    })
    public List<Role> findUserByIdAndAllRole(Long userId);
    /**
     * 给用户添加角色
     */
    @Insert("insert into users_role (user_id,role_id) values(#{userId},#{roleId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "roleId",column = "role_id")
    })
    public void addRoleToUser(@Param("userId") Long userId,@Param("roleId") Long roleId);
}
