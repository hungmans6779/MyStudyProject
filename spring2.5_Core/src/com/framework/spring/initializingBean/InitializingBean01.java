package com.framework.spring.initializingBean;

import org.springframework.beans.factory.InitializingBean;


/*
 *  實現了 InitializingBean 介面的Java Bean會在產生實體後、所有屬性被設定後呼叫初始化方法。
 *  但使用該介面會與 Spring 程式碼發生耦合，因此不建議使用。
 */
public class InitializingBean01 implements InitializingBean {

  
  public void afterPropertiesSet() throws Exception {
    System.out.println(InitializingBean01.class.getName()+" ,afterPropertiesSet()  execute ...");
  }

  
  
  
  public void showInfo(String name){
    System.out.println(InitializingBean01.class.getName()+" ,showInfo() execute ..."); 
    System.out.println("name = "+name);
  }
  
  
  
}
