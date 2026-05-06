package com.yangzhong.itlias.aop;


import com.yangzhong.itlias.dto.LogOp;
import com.yangzhong.itlias.mapper.LogMapper;
import com.yangzhong.itlias.util.Thread;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.weaver.tools.Trace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    @Autowired
    private LogMapper logMapper;
    @Around("@annotation(com.yangzhong.itlias.Enum.Log)")
    public Object logOperate(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
        Object[] args = joinPoint.getArgs();
        long begin = System.currentTimeMillis();


        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
         long time = end - begin;
//        获取操作人id
        Integer operateEmpId = Thread.getCurrentId();
//        获取操作人员的姓名
        String operateEmpName = Thread.getCurrentEmpName();
        LogOp logOp = new LogOp();
        logOp.setOperateEmpId(operateEmpId);
        logOp.setCostTime(time);
        logOp.setClassName(className);
        logOp.setMethodName(methodName);
        logOp.setMethodParams(args.toString());
        logOp.setReturnValue(result.toString());
        logOp.setOperateEmpName(operateEmpName);
        logOp.setOperateTime(LocalDateTime.now());
        logMapper.insertLog(logOp);
        Thread.removeId();
        Thread.removeName();
        return result;
    }
}
