package com.smx.ssm.service;

import com.smx.ssm.domain.Member;

import java.util.List;

//会员service
public interface MemberService {
    //根据id查询会员信息
    public Member findById(Long id);
    //查询所有会员
    public List<Member> findAll();
}
