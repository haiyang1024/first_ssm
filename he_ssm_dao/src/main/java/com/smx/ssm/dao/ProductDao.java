package com.smx.ssm.dao;
import com.smx.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProductDao {
    /**
     * 查询所有产品信息
     * @return
     */

    @Results(id = "productMap",value = {
        @Result(id = true,property = "id",column = "id"),
        @Result(property = "productNum",column = "product_num"),
        @Result(property = "productName",column = "product_name"),
        @Result(property = "cityName",column = "city_name"),
        @Result(property = "departureTime",column = "departure_time"),
        @Result(property = "productPrice",column = "product_price"),
        @Result(property = "productDesc",column = "product_desc"),
        @Result(property = "productStatus",column = "product_status"),
    })
    @Select("select * from product")
    public List<Product> findAll(Integer currentPage,Integer pageSize);


    //保存产品信息
    @Insert("insert into product (product_num,product_name,city_name,departure_time,product_price,product_desc,product_status) " +
            " values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product);

    //根据id查询
    @Select("select * from product where id=#{id}")
    @ResultMap(value = "productMap")
    public Product findById(Long id);
    //查询所有的产品
    @ResultMap(value = "productMap")
    @Select("select * from product")
    public List<Product> findAll2();

}
