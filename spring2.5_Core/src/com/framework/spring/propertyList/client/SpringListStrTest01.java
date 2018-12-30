package com.framework.spring.propertyList.client;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.propertyList.SomeListImpl;

public class SpringListStrTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_list.xml"));

    SomeListImpl list_str = (SomeListImpl) factory.getBean("listImpl_str");

    List listStr = list_str.getListStr();
    Iterator itStr = listStr.iterator();
    while (itStr.hasNext()) {
      System.out.println(itStr.next());
    }

  } // end main
  
  

}
