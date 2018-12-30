package com.framework.spring.beanNameAware.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.beanNameAware.WhatTheBeanNameAware;

public class SpringBeanNameAwareTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_BeanNameAware.xml"));
    
    WhatTheBeanNameAware beanNameAwareImpl = (WhatTheBeanNameAware)factory.getBean("beanNameAwareImpl"); 
    
    System.out.println("\n");
  
    beanNameAwareImpl.showBean();
    
  } // end main
  
  

}
