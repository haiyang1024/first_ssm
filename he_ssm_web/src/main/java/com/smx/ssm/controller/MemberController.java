package com.smx.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.smx.ssm.domain.Member;
import com.smx.ssm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired//如果有这个bean则跳过没有则注入
    private MemberService memberService;


    @ResponseBody
    @RequestMapping(value = "/findAll.do",produces = {"application/json"})
    public Map<String, JSONArray> findAll(){
        List<Member> memberList = memberService.findAll();
        JSONArray memberJson = JSONArray.parseArray(JSON.toJSONString(memberList));
        Map result=new HashMap();
        if (memberList.size()!=0){
            result.put("msg","success");
            result.put("memberJson",memberJson);
        }else {
            result.put("msg","fail");
        }
        return result;
    }
}
