package com.framework.spring.beanFactoryAware.client;

import java.util.Arrays;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.beanFactoryAware.A;


/*
 *  �� boolean containsBean(String)�G�P�_���w�W�٪� Bean �O�_�s�b�C
 *  �� Object getBean(String)�G�Ǧ^���w�W�٪�Bean�C�p�G�S����Bean�A�|�ߥX�ҥ~�C
 *  �� Object getBean(String,Class)�G�Ǧ^���w�W�٪�Bean �A����Ƭ����w�����O����C�p�G�S���� Bean �A�|�ߥX�ҥ~�C�p�G����ƿ��~�A�]�|�ߥX�ҥ~�C
 *  �� boolean isSingleton(String)�G�P�_���w�W�٪�Bean�O�_�Q�]�w�� singleton�C�p�G�S����Bean �A�|�ߥX�ҥ~�C
 *  �� String[]getAliases(String)�G�Ǧ^���w�W�٪� Bean ���O�W�C  
 */
public class SpringBeanFactoryAwareTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
     
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_BeanFactoryAware.xml")); 
    System.out.println("a'Bean is exists     => "+factory.containsBean("a"));
    System.out.println("AKB48'Bean is exists => "+factory.containsBean("AKB48"));
    System.out.println("a'Bean is singleton  => "+factory.isSingleton("a"));
  
    
    String [] aArr = factory.getAliases("a");
    System.out.println("a'Bean is Aliases => "+Arrays.toString(aArr));
    
    System.out.println("\n\n\n");
    System.out.println("�I�s a ");
    A a = (A)factory.getBean("a");
    a.printB();
    a.printB();
    a.printB();
    
    
    
    if(factory.containsBean("a")){
      System.out.println("*******************************************************************************");
      A a1 = (A)factory.getBean("a");
      a1.printB();
      System.out.println("*******************************************************************************");
    }
    
  } // end main
  
  

}
