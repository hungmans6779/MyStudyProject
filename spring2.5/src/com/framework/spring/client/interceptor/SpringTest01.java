package com.framework.spring.client.interceptor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.framework.spring.service.IService;

public class SpringTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception {
   
    // 方式1： 預設在 ClassPath 根目錄下的檔案
    ClassPathResource res = new ClassPathResource("applicationContext.xml");
    XmlBeanFactory factory = new XmlBeanFactory(res);
    
    IService service1 = (IService) factory.getBean("service"); 
    service1.service("方式1 DEMO interceptor AOP ！！！");
    
    factory.destroySingletons();
    
    
    System.out.println("\n\n\n\n\n\n");
    
    
    // 方式2：使用檔案流載入任意位置的設定檔
    Resource res1 = new FileSystemResource("D:\\EclipseDeveloper\\MyEclipse Bling Edition 10.6\\MyStudyProject\\workspace\\spring2.5\\src\\applicationContext.xml");
    XmlBeanFactory factory1 = new XmlBeanFactory(res1);
    
    IService service2 = (IService) factory1.getBean("service"); 
    service2.serviceType("2","方式2 DEMO interceptor AOP ！！！");
    
    factory1.destroySingletons();
  } // end main
  

}
