package com.framework.spring.factory_method.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.factory_method.MyFactoryBean;

public class SpringFactoryMethodTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    XmlBeanFactory factory01 = new XmlBeanFactory(new ClassPathResource("applicationContext_factoryMethod.xml"));

    MyFactoryBean bean01 = (MyFactoryBean)factory01.getBean("beanImpl01");
    
  } // end main
  

}
