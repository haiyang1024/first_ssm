package com.smx.ssm.service;

import com.smx.ssm.domain.Orders;

import java.util.List;

public interface OrdersService {
    //查询订单
    public List<Orders> findAll(Integer currentPage,Integer pageSize);

    //查询订单和产品
    public Orders findOrdersProduct(Long id);
    // 保存订单
    public void saveOrders(Orders orders);
}
