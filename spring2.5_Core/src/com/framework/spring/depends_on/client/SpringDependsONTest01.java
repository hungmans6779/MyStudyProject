package com.framework.spring.depends_on.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.depends_on.BeanB;

public class SpringDependsONTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_depends_on.xml"));
    BeanB b = (BeanB)factory.getBean("b");

  } // end 

}
