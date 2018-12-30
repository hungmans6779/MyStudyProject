package com.framework.spring.props.client;

import java.util.Properties;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.props.SomePropsImpl;

public class SpringPropsTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
   
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_props.xml"));

    SomePropsImpl propsImpl = (SomePropsImpl)factory.getBean("propsImpl");    
 
    Properties props = propsImpl.getProps();
    System.out.println("url  = "+props.getProperty("url"));
    System.out.println("name = "+props.getProperty("name"));
    
  } // end main

}
