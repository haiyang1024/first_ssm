package com.smx.ssm.dao;

import com.smx.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//会员信息
@Repository
public interface TravellerDao {
    //根据会员id查询会员信息
    @Results(id = "travellerMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "phone_num",property = "phoneNum"),
            @Result(column = "credentials_type",property = "credentialsType"),
            @Result(column = "credentials_num",property = "credentialsNum"),
            @Result(column = "traveller_type",property = "travellerType")
    })
    @Select("SELECT * FROM traveller WHERE id in (SELECT traveller_id FROM order_traveller WHERE order_id=#{id})")
    public List<Traveller> findById(Long id);
}
