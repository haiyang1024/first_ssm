package com.smx.ssm.dao;

import com.smx.ssm.domain.Orders;
import com.smx.ssm.domain.Traveller;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdersDao {
    //查询订单
    @Results(id = "ordersMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "order_num"),
            @Result(property = "orderTime",column = "order_time"),
            @Result(property = "cityName",column = "city_name"),
            @Result(property = "peopleCount",column = "people_count"),
            @Result(property = "orderDesc",column = "order_desc"),
            @Result(property = "payType",column = "pay_type"),
            @Result(property = "orderStatus",column = "order_status"),
            @Result(property = "memberId",column = "member_id"),
            @Result(property = "product",column = "product_id",one = @One(select = "com.smx.ssm.dao.ProductDao.findById")),
            @Result(property = "member",column = "member_id",one = @One(select = "com.smx.ssm.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",many = @Many(select = "com.smx.ssm.dao.TravellerDao.findById"))
    })
    @Select("select * from orders")
    public List<Orders> findAll(Integer currentPage,Integer pageSize);

    //查询订单信息
    @Select("select * from orders where id=#{id1}")
    @ResultMap("ordersMap")
    public Orders findOrdersProduct(Long id1);
    //保存订单
    @Insert("insert into orders (order_num,order_time,people_count,order_desc,pay_type,order_status,product_id,member_id) values (#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{productId},#{memberId})")
    public void saveOrders(Orders orders);
}
