package com.framework.spring.initializingBean.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.initializingBean.InitializingBean01;

public class SpringInitializingBeanTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_InitializingBean.xml"));
  
    InitializingBean01 init01 = (InitializingBean01)factory.getBean("initializingBean01"); 
    init01.showInfo("kevin-01");
   
  } // end main

  
  
}
