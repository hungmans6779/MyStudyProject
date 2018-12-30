package com.framework.spring.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.framework.spring.service.IService;

public class SpringTest02 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    // 載入設檔
    
    // 方式3：載入多個設定檔(多個設定檔以字串陣列形式傳入)，並傳給遞給 XmlBeanFactory 建構函數 
    ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{
                                                                                                "applicationContext_1.xml",
                                                                                                "applicationContext_2.xml"});
    
    BeanFactory factory = (BeanFactory)appContext;
    
    IService service = (IService)factory.getBean("serviceImpl");
    service.service("Demo SpringTest02");
   
  } // end main
  
  

}
