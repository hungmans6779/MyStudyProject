package com.framework.spring.factory_method;

public class MyFactoryBean {

  private MyFactoryBean(){
    System.out.println("��ҼҦ��إߪ���...");  
  }
  
  
  private static class InnerClass{
    private static MyFactoryBean instance = new MyFactoryBean();
  }
  
  
  public static MyFactoryBean createInstance(){
    return InnerClass.instance;
  }
  
  
  // public 
}
