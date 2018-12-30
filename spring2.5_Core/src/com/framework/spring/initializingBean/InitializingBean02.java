package com.framework.spring.initializingBean;



public class InitializingBean02 {
 
  
  public void afterPropertiesSet() throws Exception {
    System.out.println(InitializingBean02.class.getName()+",afterPropertiesSet() execute .....");
  }
  
  
  public void showInfo(String name){
    System.out.println(InitializingBean02.class.getName()+",showInfo() execute..."); 
    System.out.println("name = "+name);
  }
  
  
  
}
