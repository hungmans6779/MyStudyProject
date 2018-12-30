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
    
    // ���J�]�w��
    // �覡1�G �w�]�b ClassPath �ڥؿ��U���ɮ�
    // XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
    
    
    // �覡2�G�ϥ��ɮ׬y���J���N��m���]�w��
    XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("D:\\EclipseDeveloper\\MyEclipse Bling Edition 10.6\\MyStudyProject\\workspace\\spring2.5\\src\\applicationContext.xml"));
    
    
    
    // �q�]�w�ɤ���o��k
    IService service = (IService) factory.getBean("serviceImpl"); 
    
    // ���� service ��k
    service.service("DEMO Spring Core�I�I�I");       
    
    // �P�����ͪ� Bean
    factory.destroySingletons();    
   
  } // end main

  
}
