package com.smx.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.smx.ssm.domain.SysLog;
import com.smx.ssm.service.LogAopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private LogAopService logAopService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(Integer currentPage,Integer pageSize){
        ModelAndView mv=new ModelAndView();
        List<SysLog> sysLogList = logAopService.findAll(currentPage, pageSize);
        PageInfo pageInfo=new PageInfo(sysLogList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }
}
