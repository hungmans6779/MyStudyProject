package com.springframework.interceptor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.springframework.service.impl.AOPServiceImpl;


/*
 *  ��k�e�d�I��
 *  
 *  ��{�� MethodBeforeAdvice�@�����C��k�e�d�I���b������w��k�e�Q�I�s�A�ѼƤ��O���I�s����k�B����ɳQ�ǤJ���ѼơB�Q�d�I�� Bean�C
 *  �Q�d�I�������k�b applicationContext.xml ���]�w�C
 */
public class MethodBeforeInterceptor implements MethodBeforeAdvice {

  
  /*
   *  �I�s���󪺤�k�e�N����Ӥ�k�C�ѼƤ��O���Q�I�s����k�A�Q�I�s��k���ѼơB����
   */
  public void before(Method method, Object[] args, Object obj) throws Throwable {
  
    System.out.println(MethodBeforeInterceptor.class.getName()+" before() execute ...");
    System.out.println("�Y�N�n�����k�W�٬��G" +  method.getName());
    
    if(obj instanceof AOPServiceImpl){
      String name = ((AOPServiceImpl)obj).getName();
      System.out.println(MethodBeforeInterceptor.class.getName() + " ,name = " + name);
      if(name == null){
        throw new NullPointerException("name �ݩʤ��ର null ");
      }
    } // end if(obj instanceof AOPServiceImpl){ 
    
  } // end before


}
