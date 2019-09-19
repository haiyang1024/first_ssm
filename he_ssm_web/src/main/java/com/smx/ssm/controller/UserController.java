package com.smx.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.smx.ssm.domain.Role;
import com.smx.ssm.domain.UserInfo;
import com.smx.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //根据用户id查询用户详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(Long id){
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo = userService.findByUserId(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 查询所有用户
     * @return
     */
    @PreAuthorize("hasRole('admin')")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(Integer currentPage,Integer pageSize){
        ModelAndView mv=new ModelAndView();
        List<UserInfo> userList = userService.findAll(currentPage,pageSize);
        PageInfo pageInfo=new PageInfo(userList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 保存用户
     * @param userInfo
     * @return
     */
    @PreAuthorize("authentication.principal.username == 'admin'")
    @RequestMapping("/save.do")
    public String saveUser(UserInfo userInfo){
        //System.out.println(userInfo);
        userService.saveUser(userInfo);
        return "redirect:findAll.do?currentPage=1&pageSize=5";//分页查询记得添加参数
    }

    /**
     * 用户添加角色
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(Long id){
        ModelAndView mv=new ModelAndView();
        UserInfo user = userService.findByUserId(id);
        //System.out.println(user);
        List<Role> roleList = userService.findUserByIdAndAllRole(id);
        System.out.println(roleList);
        mv.addObject("user",user);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }
    /**
     * 保存角色
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(Long userId,String[] ids){
        for (String roleId : ids) {
            userService.addRoleToUser(userId,Long.parseLong(roleId));
        }
        return "redirect:findAll.do?currentPage=1&pageSize=5";//记得添加参数
    }
}
