package com.framework.spring.propertySet.client;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.propertySet.SomeSetStrImpl;


public class SpringSetStrTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_set.xml"));

    SomeSetStrImpl set_str = (SomeSetStrImpl) factory.getBean("setImpl_str");

    Set listStr = set_str.getSetStr();
    Iterator itStr = listStr.iterator();
    while (itStr.hasNext()) {
      System.out.println(itStr.next());
    }

  }

}
