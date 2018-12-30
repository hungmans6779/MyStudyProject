package com.framework.spring.factory_method;

public class MyFactoryBean {

  private MyFactoryBean(){
    System.out.println("單例模式建立物件...");  
  }
  
  
  private static class InnerClass{
    private static MyFactoryBean instance = new MyFactoryBean();
  }
  
  
  public static MyFactoryBean createInstance(){
    return InnerClass.instance;
  }
  
  
  // public 
}
