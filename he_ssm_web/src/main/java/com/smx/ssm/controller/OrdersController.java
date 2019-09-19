package com.smx.ssm.controller;
import com.github.pagehelper.PageInfo;
import com.smx.ssm.domain.Orders;
import com.smx.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    //查询所有订单
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(Integer currentPage,Integer pageSize){
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(currentPage,pageSize);
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }
    //根据id查询所有订单
    @RequestMapping("/findById.do")
    public ModelAndView findById(Long id){
        ModelAndView mv=new ModelAndView();
        Orders ordersProduct = ordersService.findOrdersProduct(id);
        mv.addObject("orders",ordersProduct);
        mv.setViewName("orders-show");
        return mv;
    }
    //保存订单
    @RequestMapping(value = "/save.do",method = RequestMethod.POST)
    public String saveOrders(Orders orders){
        System.out.println(orders);
        ordersService.saveOrders(orders);
        return "redirect:findAll.do?currentPage=1&pageSize=5";
    }
}
