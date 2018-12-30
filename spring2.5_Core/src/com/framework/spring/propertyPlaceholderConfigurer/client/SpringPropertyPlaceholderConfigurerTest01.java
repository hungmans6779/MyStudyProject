package com.framework.spring.propertyPlaceholderConfigurer.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.framework.spring.propertyPlaceholderConfigurer.PropertyPlaceholderConfigurer01;

public class SpringPropertyPlaceholderConfigurerTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_PropertyPlaceholderConfigurer.xml");
    
    PropertyPlaceholderConfigurer01 prop01 = (PropertyPlaceholderConfigurer01)context.getBean("propertyPlaceholderConfigurerBean");
    System.out.println("*************************************************************************************************");
    System.out.println("01. driverClassName  = " + prop01.getDriverClassName());
    System.out.println("02. url              = " + prop01.getUrl());
    System.out.println("03. username         = " + prop01.getUsername());
    System.out.println("04. password         = " + prop01.getPassword());
    System.out.println("*************************************************************************************************");  

  } // end main

  
  
}
