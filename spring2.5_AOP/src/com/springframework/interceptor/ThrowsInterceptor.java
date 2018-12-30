package com.springframework.interceptor;

import java.lang.reflect.Method;

import javax.security.auth.login.AccountException;

import org.springframework.aop.ThrowsAdvice;


/*
 * �ҥ~�d�I��
 * 
 * ��{��ThrowsAdvice �����C�p�G���w����k�����ҥ~�Q�ߥX�A�h��Q�I�s�C 
 * �P�����d�I���������P�AThrowsAdvice �����S���w�q�����k�A�]�����ݭn��{�����k�C
 */
public class ThrowsInterceptor implements ThrowsAdvice {
  
  // ��k�@
  public void afterThrowing(Method method, Object[] args, Object obj, AccountException ex) throws Throwable {
    System.out.println("\n");
    System.out.println(ThrowsInterceptor.class.getName() + " afterThrowing() ��k�@  execute...");
    System.out.println("��k�W�� " + method.getName() + "�A�ߥX�ҥ~�G" + ex);
  } // end afterThrowing(Method method,Object [] args,Object object,AccountException ex)


  
  // ��k�G
  public void afterThrowing(NullPointerException ex) throws Throwable {
    System.out.println("\n");
    System.out.println(ThrowsInterceptor.class.getName() + " afterThrowing() ��k�G  execute...");
    System.out.println("�ߥX�F�ҥ~�G" + ex);
  } // end afterThrowing(NullPointerException ex)
  
}
