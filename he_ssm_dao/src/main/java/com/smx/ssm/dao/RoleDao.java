package com.smx.ssm.dao;

import com.smx.ssm.domain.Permission;
import com.smx.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    /**
     * 根据用户id查询角色信息
     * @param userId
     * @return
     */
    @Results(id = "roleMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "role_name"),
            @Result(property = "roleDesc",column = "role_desc"),
            @Result(property = "permissions",column = "id",many = @Many(select = "com.smx.ssm.dao.PermissionDao.findByRoleId"))
    })
    @Select("select * from role where id in (select role_id FROM users_role WHERE user_id =#{userId})")//根据用户id查询角色id，根据角色id查询角色信息
    public List<Role> findByRoleId(Long userId);
    /**
     * 查询所有角色信息
     */
    @ResultMap("roleMap")
    @Select("select * from role")
    public List<Role> findAll(Integer currentPage,Integer pageSize);
    /**
     * 添加角色
     */
    @Insert("insert into role (role_name,role_desc) values (#{roleName},#{roleDesc})")
    public void saveRole(Role role);
    /**
     * 根据roleId 查询所有角色信息
     */
    @Select("select * from role where id=#{roleId}")
    @ResultMap("roleMap")
    public Role findById(Long roleId);
    /**
     *根据roleId 查询角色可用的权限
     */
    @Select("select * from permission where id not in (select permission_id from role_permission where role_id=#{roleId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "permissionName",column = "permission_name"),
            @Result(property = "url",column = "url")
    })
    public List<Permission> findOtherPermission(Long roleId);
    /**
     * 给角色添加权限
     */
    @Insert("insert into role_permission (role_id,permission_id) values (#{roleId},#{permissionId})")
    public void addRoleToUser(@Param("roleId")Long roleId,@Param("permissionId")Long permissionId);

}
