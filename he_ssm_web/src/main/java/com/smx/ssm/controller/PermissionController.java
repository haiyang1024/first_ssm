package com.smx.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.smx.ssm.domain.Permission;
import com.smx.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RequestMapping("/permission")
@Controller
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    /**
     * 查询所有权限
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(Integer currentPage,Integer pageSize){
        ModelAndView mv=new ModelAndView();
        List<Permission> permissionList = permissionService.findAll(currentPage,pageSize);
        PageInfo pageInfo=new PageInfo(permissionList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }
    /**
     * 添加权限
     * @return
     */
    @RequestMapping("/save.do")
    public String savePermission(Permission permission){
        permissionService.savePermission(permission);
        return "redirect:findAll.do?currentPage=1&pageSize=5";
    }
}
