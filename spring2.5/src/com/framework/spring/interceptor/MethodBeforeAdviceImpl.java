package com.framework.spring.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;


/*
 *  在某些方法前執行的攔截器
 */
public class MethodBeforeAdviceImpl implements MethodBeforeAdvice {

  private static Logger logger = Logger.getLogger("MethodBeforeAdviceImpl");
  
  public void before(Method method, Object[] args, Object obj) throws Throwable {
   
    logger.info("*****************************************************************");
    logger.info(MethodBeforeAdviceImpl.class.getName()+",before()...");
    logger.info("執行前檢查 .....");
    logger.info("Method ： " + method.getName());       // 輸出方法名
    logger.info("Args   ： " + Arrays.toString(args));  // 輸出方法的參數名
    logger.info("Obj    ： " + obj);                    // 輸出物件
    logger.info("*****************************************************************");
    
  } // end before
  
  

}
