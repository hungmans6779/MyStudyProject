package com.framework.spring.destoryBean.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.destoryBean.DestroyBean01;
import com.framework.spring.destoryBean.DestroyBean02;

public class SpringDestroyBeanTest02 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_DestroyBean.xml"));
    
    DestroyBean02 destroyBean02 = (DestroyBean02)factory.getBean("destoryBean02");
    destroyBean02.showInfo();
    
  } // end main

  
  
}
