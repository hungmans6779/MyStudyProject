package com.framework.spring.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.dao.transaction.TransactionRun;

public class Client_Transaction_Test01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
  
    // 載入設定檔
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_Transaction.xml"));

    // 取得 Bean 
    TransactionRun tr = (TransactionRun)factory.getBean("transactionRunId");
    
    // 主方法，供 Spring 呼叫
    tr.run();
    
  } // end main
  
  

}
