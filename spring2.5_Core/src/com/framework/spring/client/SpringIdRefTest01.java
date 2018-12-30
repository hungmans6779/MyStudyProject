package com.framework.spring.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.service.IService;
import com.framework.spring.service.ServiceImpl;

public class SpringIdRefTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
   
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_idref.xml"));

    IService serviceImpl_1 = (IService)factory.getBean("serviceImpl_1");
    IService serviceImpl_2 = (IService)factory.getBean("serviceImpl_2");
  
    
    System.out.println(SpringIdRefTest01.class.getName());
    serviceImpl_1.service("kevin_1");
    
    serviceImpl_2.service("kevin_2");
   
    
  } // end main

  
}
