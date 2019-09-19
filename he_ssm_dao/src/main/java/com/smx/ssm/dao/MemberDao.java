package com.smx.ssm.dao;

import com.smx.ssm.domain.Member;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//会员信息
@Repository
public interface MemberDao {
    //根据会员id查询会员信息
    @Results(id = "memberMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "nick_name",property = "nickName"),
            @Result(column = "phone_num",property = "phoneNum"),
            @Result(column = "email",property = "email")
    })
    @Select("select * from `member` where id = #{id}")
    public Member findById(Long id);

    //查询所有会员
    @ResultMap("memberMap")
    @Select("SELECT * FROM `member`")
    public List<Member> findAll();
}
