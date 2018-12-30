package com.framework.spring.propertyOverrideConfigurer.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.propertyOverrideConfigurer.PropertyOverrideConfigurer01;

public class SpringPropertyOverrideConfigurerTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
   
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_PropertyOverrideConfigurer.xml");
    
    PropertyOverrideConfigurer01 prop01 = (PropertyOverrideConfigurer01)context.getBean("myPropertyBean01");
    System.out.println("*****************************************************");
    System.out.println("01. name        = " + prop01.getName());
    System.out.println("02. age         = " + prop01.getAge());
    System.out.println("03. worker      = " + prop01.getWorker());
    System.out.println("04. workCompany = " + prop01.getWorkCompany());
    System.out.println("*****************************************************");  
    
  } // end main
  
  

}
