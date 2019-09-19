package com.smx.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.smx.ssm.dao.ProductDao;
import com.smx.ssm.domain.Product;
import com.smx.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;


    @Override
    public List<Product> findAll(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);//使用mybatis自己的分页插件,进行分页
        return productDao.findAll(currentPage,pageSize);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> findAll2() {
        return productDao.findAll2();
    }
}
