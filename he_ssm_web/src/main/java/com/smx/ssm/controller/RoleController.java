package com.smx.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.smx.ssm.domain.Permission;
import com.smx.ssm.domain.Role;
import com.smx.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(Integer currentPage,Integer pageSize){
        ModelAndView mv=new ModelAndView();
        List<Role> roleList = roleService.findAll(currentPage,pageSize);
        PageInfo pageInfo= new PageInfo(roleList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }
    /**
     * 保存角色
     */
    @RolesAllowed("admin")
    @RequestMapping("/save.do")
    public String saveRole(Role role){
        roleService.saveRole(role);
        return "redirect:findAll.do?currentPage=1&pageSize=5";
    }
    /**
     * 给角色添加权限
     */
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id") Long roleId){
        ModelAndView mv=new ModelAndView();
        Role role = roleService.findById(roleId);
        List<Permission> permissionList = roleService.findOtherPermission(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }
    /**
     * 添加权限
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(Long roleId,String[] ids){
        for (String id : ids) {
            roleService.addRoleToUser(roleId,Long.parseLong(id));
        }
        return "redirect:findAll.do?currentPage=1&pageSize=5";
    }
}
