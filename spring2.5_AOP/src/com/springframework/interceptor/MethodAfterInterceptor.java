package com.springframework.interceptor;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import com.springframework.service.impl.AOPServiceImpl;


/*
 *  ��k���d�I��
 *  
 *  ��{��AfterReturningAdvice�����C�Ǧ^���d�I���b���槹���w��k�B�öǦ^����Q�I�s�C
 *  �p�G���Ǧ^�ȡA�i�H����Ǧ^�ȡA�_�h�� null �C�ѼƤ��O����k�Ǧ^�ȡB�Q�I�s����k�B����ɳQ�ǤJ���ѼơB�Q�d�I�� Bean�C
 *  
 */
public class MethodAfterInterceptor implements AfterReturningAdvice{

  
  public void afterReturning(Object value, Method method, Object[] args, Object obj) throws Throwable {
    System.out.println("\n");
    System.out.println(MethodAfterInterceptor.class.getName() + " afterReturning()  execute ...");
    
    System.out.println("��k�W�� method = " + method.getName());
 
    String name = ((AOPServiceImpl)obj).getName();
    System.out.println(MethodAfterInterceptor.class.getName() + " , �Ǧ^�� value = " + value + ",name = " + name);
  } // end afterReturning

  
}
