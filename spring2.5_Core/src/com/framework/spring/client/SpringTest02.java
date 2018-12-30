package com.framework.spring.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.framework.spring.service.IService;

public class SpringTest02 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    // ���J�]��
    
    // �覡3�G���J�h�ӳ]�w��(�h�ӳ]�w�ɥH�r��}�C�Φ��ǤJ)�A�öǵ����� XmlBeanFactory �غc��� 
    ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{
                                                                                                "applicationContext_1.xml",
                                                                                                "applicationContext_2.xml"});
    
    BeanFactory factory = (BeanFactory)appContext;
    
    IService service = (IService)factory.getBean("serviceImpl");
    service.service("Demo SpringTest02");
   
  } // end main
  
  

}
