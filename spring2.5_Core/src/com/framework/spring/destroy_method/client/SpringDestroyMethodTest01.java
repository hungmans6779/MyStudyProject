package com.framework.spring.destroy_method.client;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringDestroyMethodTest01 {

  
  /**
   * @param args
   */
  public static void main(String[] args) {
    
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_destroyMethod.xml"));
    
    BasicDataSource bds = (BasicDataSource) factory.getBean("dataSource");

    System.out.println(SpringDestroyMethodTest01.class.getName());
    System.out.println("01.driverClassName   = " + bds.getDriverClassName());
    System.out.println("02.url               = " + bds.getUrl());
    System.out.println("03.username          = " + bds.getUsername());
    System.out.println("04.password          = " + bds.getPassword());
    System.out.println("05.defaultAutoCommit = " + bds.getDefaultAutoCommit());
    System.out.println("06.maxActive         = " + bds.getMaxActive());
   
  } // end main
  

}
