package com.framework.spring.beanNameAware;

import org.springframework.beans.factory.BeanNameAware;


/*
 *  BeanNameAware ������ JavaBean ���D�ۤv�b�]�w�ɤ���id �C��{ BeanNameAware �����A��{��k�L�� setBeanName() ��k�A
 *  ��l�ƸӪ���� Spring �N�|����Ӧ^�ɤ�k�A�N id �]�w�i�ӡCBean ���]�w�@�Ӽg�{���A���� id �W�٧Y�i�C
 */
public class WhatTheBeanNameAware implements BeanNameAware {

  
  private String beanName;   // �P�� Bean

  public void setBeanName(String beanName) {
    this.beanName = beanName;
    
    System.out.println("\n");
    System.out.println(WhatTheBeanNameAware.class.getName()+", setBeanName Method beanName = " + beanName);
  } // end setBeanName
  
  
  
  public void showBean(){
    System.out.println("bean Id = " + this.beanName);
  }

  
  
}
