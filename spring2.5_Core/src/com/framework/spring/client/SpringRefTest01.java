package com.framework.spring.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.service.IService;

public class SpringRefTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_ref.xml"));
           
    
    IService service_1 = (IService) factory.getBean("serviceImpl_1"); 
    service_1.service("Demo SpringRefTest01 for serviceImpl_1");
    System.out.println("\n");
    
    
    
    IService service_2 = (IService) factory.getBean("serviceImpl_2"); 
    service_2.service("Demo SpringRefTest01 for serviceImpl_2");
    System.out.println("\n");
    

    
    IService service_3 = (IService) factory.getBean("serviceImpl_3"); 
    service_3.service("Demo SpringRefTest01 for serviceImpl_3");
    System.out.println("\n");
    
  } // end main
  
  
  
  

}
