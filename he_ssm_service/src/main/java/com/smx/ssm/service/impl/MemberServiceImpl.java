package com.smx.ssm.service.impl;

import com.smx.ssm.dao.MemberDao;
import com.smx.ssm.domain.Member;
import com.smx.ssm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//会员实现类
@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;
    @Override
    public Member findById(Long id) {
        return memberDao.findById(id);
    }

    @Override
    public List<Member> findAll() {
        System.out.println(memberDao.findAll());
        return memberDao.findAll();
    }
}
