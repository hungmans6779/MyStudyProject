package com.springframework.interceptor;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import com.springframework.service.impl.AOPServiceImpl;


/*
 *  方法後攔截器
 *  
 *  實現自AfterReturningAdvice介面。傳回後攔截器在執行完指定方法、並傳回之後被呼叫。
 *  如果有傳回值，可以取到傳回值，否則為 null 。參數分別為方法傳回值、被呼叫的方法、執行時被傳入的參數、被攔截的 Bean。
 *  
 */
public class MethodAfterInterceptor implements AfterReturningAdvice{

  
  public void afterReturning(Object value, Method method, Object[] args, Object obj) throws Throwable {
    System.out.println("\n");
    System.out.println(MethodAfterInterceptor.class.getName() + " afterReturning()  execute ...");
    
    System.out.println("方法名稱 method = " + method.getName());
 
    String name = ((AOPServiceImpl)obj).getName();
    System.out.println(MethodAfterInterceptor.class.getName() + " , 傳回值 value = " + value + ",name = " + name);
  } // end afterReturning

  
}
