package com.framework.spring.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.framework.spring.service.IService;

public class SpringTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    // 載入設定檔
    // 方式1： 預設在 ClassPath 根目錄下的檔案
    // XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
    
    
    // 方式2：使用檔案流載入任意位置的設定檔
    XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("D:\\EclipseDeveloper\\MyEclipse Bling Edition 10.6\\MyStudyProject\\workspace\\spring2.5\\src\\applicationContext.xml"));
    
    
    
    // 從設定檔中獲得方法
    IService service = (IService) factory.getBean("serviceImpl"); 
    
    // 執行 service 方法
    service.service("DEMO Spring Core！！！");       
    
    // 銷毀產生的 Bean
    factory.destroySingletons();    
   
  } // end main

  
}
