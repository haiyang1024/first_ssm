package com.smx.ssm.service;



import com.smx.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    //查询所有产品信息
    public List<Product> findAll(Integer currentPage,Integer pageSize);
    //保存产品信息
    public void save(Product product);
    //查询所有订单订单
    public List<Product> findAll2();

}
