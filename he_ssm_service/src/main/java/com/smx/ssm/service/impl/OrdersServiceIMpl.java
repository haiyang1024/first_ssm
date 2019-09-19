package com.smx.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.smx.ssm.dao.OrdersDao;
import com.smx.ssm.domain.Orders;
import com.smx.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceIMpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;


    @Override
    public List<Orders> findAll(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);//启用mybatis自己的分页查询
        return ordersDao.findAll(currentPage,pageSize);
    }

    //查询订单和产品
    @Override
    public Orders findOrdersProduct(Long id) {
        return ordersDao.findOrdersProduct(id);
    }
    //保存订单
    @Override
    public void saveOrders(Orders orders) {
        ordersDao.saveOrders(orders);
    }
}
