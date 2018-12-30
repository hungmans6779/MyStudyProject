package com.framework.spring.init_method.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.init_method.MyFactoryBean;

public class client {

  
  public static void main(String [] args){
   
    
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_initMethod.xml"));
    
    
    MyFactoryBean bean = (MyFactoryBean)factory.getBean("beanImpl");
    
  } // end main
  
  
  
}
