package com.framework.spring.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.dao.transaction.TransactionRun;

public class Client_Transaction_Test01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
  
    // ���J�]�w��
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_Transaction.xml"));

    // ���o Bean 
    TransactionRun tr = (TransactionRun)factory.getBean("transactionRunId");
    
    // �D��k�A�� Spring �I�s
    tr.run();
    
  } // end main
  
  

}
