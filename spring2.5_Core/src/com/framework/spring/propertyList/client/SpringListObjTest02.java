package com.framework.spring.propertyList.client;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.propertyList.SomeListObjImpl;

public class SpringListObjTest02 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_list.xml")); 

    SomeListObjImpl list_Obj = (SomeListObjImpl)factory.getBean("listImpl_obj");
    
    
    BasicDataSource bds = null;
    List listObj = list_Obj.getListObj();
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
