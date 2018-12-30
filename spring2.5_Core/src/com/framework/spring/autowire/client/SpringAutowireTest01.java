package com.framework.spring.autowire.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.autowire.entity.MyFactoryBeanA;
import com.framework.spring.autowire.entity.MyFactoryBeanB;

public class SpringAutowireTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_autowire.xml")); 
    System.out.println("\n");
    
    
    // DEMO => byName�G�ھڦW�٦۰ʸ˰t�A�p�G Bean �����ӦW�� dateSource ���ݩʡASpring �|�� id �� dataSource ���ݩʳ]�w��� Bean ���C
    MyFactoryBeanA beanA = (MyFactoryBeanA)factory.getBean("beanAImpl");
    beanA.serviceA("MyFactoryBeanA class");
    System.out.println("\n");
    
    
    // DEMO => byType�G�ھ������۰ʸ˰t�A�p�G Bean ������ DataSource �������ݩʡASpring �|�� DataSource ������ Bean �]�w��� Bean ���C
    MyFactoryBeanB beanB = (MyFactoryBeanB)factory.getBean("beanBImpl");
    beanB.serviceB("MyFactoryBeanB class");
    System.out.println("\n");
    
  } // end main
  
  

}
