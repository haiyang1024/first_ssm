package com.smx.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.smx.ssm.domain.Product;
import com.smx.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RolesAllowed("admin")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(Integer currentPage,Integer pageSize){

        ModelAndView mv=new ModelAndView();
        List<Product> productList = productService.findAll(currentPage,pageSize);
        PageInfo pageInfo=new PageInfo(productList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }
    @RequestMapping(value = "/save.do",method = RequestMethod.POST)
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll.do?currentPage=1&pageSize=5";
    }
    @ResponseBody
    @RequestMapping(value = "/findAll2.do",produces = {"application/json"})
    public Map<String,JSONArray> findAll2(){
        List<Product> productList = productService.findAll2();
        JSONArray productJsonArray = JSONArray.parseArray(JSON.toJSONString(productList));
        Map result=new HashMap();
        if (!productJsonArray.isEmpty()){
            result.put("msg","success");
            result.put("productJson",productJsonArray);
        }else {
            result.put("message","查询失败");
        }
        return result;
    }
}
