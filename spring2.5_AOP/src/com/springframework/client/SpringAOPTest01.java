package com.springframework.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springframework.service.IAOPService;

public class SpringAOPTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception{
  
     XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
     IAOPService aopServiceBean = (IAOPService)factory.getBean("aopService");
     
     System.out.println("\n\n\n");
     
     
     System.out.println("¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹");
     System.out.println("¡m ©I¥s aopServiceBean.withAOP() Method ¡n \n");
     aopServiceBean.withAOP();
     System.out.println("¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹");
     System.out.println("\n\n\n\n\n");
     
     
     System.out.println("¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹");
     System.out.println("¡m ©I¥s aopServiceBean.withoutAOP() Method ¡n \n");
     aopServiceBean.withoutAOP();
     System.out.println("¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹");
     System.out.println("\n\n\n\n\n");
     
    
     System.out.println("¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹");
     System.out.println("¡m ©I¥s factory.destroySingletons() Method ¡n \n");
     factory.destroySingletons();
     System.out.println("¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹¡¹");
     System.out.println("\n\n\n\n\n");
     

  } // end main

  
  
}
