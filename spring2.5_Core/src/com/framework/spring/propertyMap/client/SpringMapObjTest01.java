package com.framework.spring.propertyMap.client;

import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.propertyMap.SomeMapObjImpl;

public class SpringMapObjTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_map.xml"));
    
    SomeMapObjImpl mapImpl = (SomeMapObjImpl)factory.getBean("mapImpl_obj");
    Map mapObj = mapImpl.getMapObj();
    
    
    System.out.println("\n");
    System.out.println("字串的資訊");
    String value_1 = (String)mapObj.get("key_str_1");
    String value_2 = (String)mapObj.get("key_str_2");
    System.out.println("val_1 = "+value_1);
    System.out.println("val_2 = "+value_2);
   
    
    System.out.println("\n");
    System.out.println("物件的資訊");
    BasicDataSource bds = (BasicDataSource)mapObj.get("key_obj_1");
    System.out.println("bds driverClassName   = "+bds.getDriverClassName());
    System.out.println("bds url               = "+bds.getUrl());
    System.out.println("bds username          = "+bds.getUsername());
    System.out.println("bds password          = "+bds.getPassword());
    System.out.println("bds defaultAutoCommit = "+bds.getDefaultAutoCommit());
    System.out.println("bds maxActive         = "+bds.getMaxActive());
    
  } // end main

  
  
}
