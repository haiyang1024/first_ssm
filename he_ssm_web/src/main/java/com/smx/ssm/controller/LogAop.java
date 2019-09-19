package com.smx.ssm.controller;

import com.smx.ssm.domain.Product;
import com.smx.ssm.domain.SysLog;
import com.smx.ssm.service.LogAopService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;


@Component
@Aspect
public class LogAop {
    private Date visitTime;
    private Class clazz;
    private Method method;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private LogAopService logAopService;
    //前置通知
    @Before("execution(* com.smx.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        visitTime=new Date();
        clazz=joinPoint.getTarget().getClass();//得到访问的类
        String name = clazz.getName();
        if ("com.smx.ssm.controller.SysLogController".equals(name)){
            return;
        }else {
            String methodName = joinPoint.getSignature().getName();//得到访问的方法名
            Object[] args=null;
            args=joinPoint.getArgs();//得到方法参数
            if (args==null||0==args.length){
                method=clazz.getMethod(methodName);
            }else {
                Class[] classes=new Class[args.length];
                for (int i = 0; i <args.length; i++) {
                    //if (args[i].getClass()==)
                    classes[i]=  args[i].getClass();// 如果强转的话 会报java.lang.Integer cannot be cast to java.lang.Class 要得到数组的字节码文件
                }
                //Product product=new Product();
                method=clazz.getMethod(methodName,classes);//Class<?>... parameterTypes 接受一个class类型的数组 String.class
            }
        }

    }
    //后置通知
    @After("execution(* com.smx.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint){
        Long executionTime=new Date().getTime()-visitTime.getTime();//获取访问时长
        String url=null;
        if (clazz!=null&&method!=null&&clazz!=LogAop.class){
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation!=null){
                String[] classValue = classAnnotation.value();
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation!=null){
                    String[] methodValue = methodAnnotation.value();
                    url=classValue[0]+methodValue[0];//获取url
                    //获取ip
                    String ip=request.getRemoteAddr();
                    //获取当前用户
                    SecurityContext context = SecurityContextHolder.getContext();//request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")
                    User user = (User) context.getAuthentication().getPrincipal();//获取当前登录的用户
                    String username = user.getUsername();
                    SysLog sysLog=new SysLog();
                    sysLog.setVisitTime(visitTime);
                    sysLog.setMethod("[类名 ]"+clazz.getName()+"[方法名 ]"+method.getName());
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setIp(ip);
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    String name = clazz.getName();
                    logAopService.saveLog(sysLog);
                }
            }

        }

    }
}
