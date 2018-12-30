package com.framework.spring.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.xml.sax.InputSource;

import com.framework.spring.service.IService;

public class SpringTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception{
   
    // ���J�]�w��
    
    // �覡1�G �w�]�b ClassPath �ڥؿ��U���ɮ�
    XmlBeanFactory factory1 = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
    
    IService service1 = (IService)factory1.getBean("serviceImpl");
    service1.service("Demo SpringTest01 factory1...");
    
    factory1.destroySingletons();
    
    
    System.out.println("********************************************************************************************************");
    
    
    // �覡2�G�ϥ��ɮ׬y���J���N��m���]�w��
    XmlBeanFactory factory2 = new XmlBeanFactory(new FileSystemResource("D:\\EclipseDeveloper\\MyEclipse Bling Edition 10.6\\MyStudyProject\\workspace\\spring2.5_Core\\src\\applicationContext.xml"));
   
    IService service2 = (IService)factory2.getBean("serviceImpl");
    service2.service("Demo SpringTest01 factory2...");
    
    factory2.destroySingletons();
     
  } // end main
  

}
