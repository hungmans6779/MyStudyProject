package com.framework.spring.initializingBean.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.initializingBean.InitializingBean02;

public class SpringInitializingBeanTest02 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_InitializingBean.xml"));
    
    InitializingBean02 init02 = (InitializingBean02)factory.getBean("initializingBean02"); 
    init02.showInfo("kevin-02");
  
  } // end main

  
}
