package com.framework.spring.constructor.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.constructor.MyBean;

public class SpringConstructorTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
  
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_Constructor.xml"));

    MyBean bean = (MyBean)factory.getBean("beanImpl01");
    
    System.out.println("*********************************************************************");
    System.out.println(SpringConstructorTest01.class.getName());
    System.out.println("01. bean01 = " + bean.getBean01());
    System.out.println("02. bean02 = " + bean.getBean02());
    System.out.println("03. i      = " + bean.getI());
    System.out.println("*********************************************************************");
  } // end main

}
