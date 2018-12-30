package com.framework.spring.propertySet.client;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.propertySet.SomeSetObjImpl;



public class SpringSetObjTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_set.xml")); 

    SomeSetObjImpl set_Obj = (SomeSetObjImpl)factory.getBean("setImpl_obj");
    
    
    BasicDataSource bds = null;
    Set listObj = set_Obj.getSetObj();
    Iterator itObj = listObj.iterator();
    Object obj = null;
    while(itObj.hasNext()){
      obj = itObj.next();
      if(obj instanceof BasicDataSource){
        bds = (BasicDataSource)obj;
        System.out.println("driverClassName   = "+bds.getDriverClassName());
        System.out.println("url               = "+bds.getUrl());
        System.out.println("username          = "+bds.getUsername());
        System.out.println("password          = "+bds.getPassword());
        System.out.println("defaultAutoCommit = "+bds.getDefaultAutoCommit());
        System.out.println("maxActive         = "+bds.getMaxActive());  
      }
     
    }

  }
  
  

}
