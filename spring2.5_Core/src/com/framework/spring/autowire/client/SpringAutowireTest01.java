package com.framework.spring.autowire.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.autowire.entity.MyFactoryBeanA;
import com.framework.spring.autowire.entity.MyFactoryBeanB;

public class SpringAutowireTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_autowire.xml")); 
    System.out.println("\n");
    
    
    // DEMO => byName：根據名稱自動裝配，如果 Bean 中有個名為 dateSource 的屬性，Spring 會把 id 為 dataSource 的屬性設定到該 Bean 中。
    MyFactoryBeanA beanA = (MyFactoryBeanA)factory.getBean("beanAImpl");
    beanA.serviceA("MyFactoryBeanA class");
    System.out.println("\n");
    
    
    // DEMO => byType：根據類型自動裝配，如果 Bean 中有個 DataSource 類型的屬性，Spring 會把 DataSource 類型的 Bean 設定到該 Bean 中。
    MyFactoryBeanB beanB = (MyFactoryBeanB)factory.getBean("beanBImpl");
    beanB.serviceB("MyFactoryBeanB class");
    System.out.println("\n");
    
  } // end main
  
  

}
