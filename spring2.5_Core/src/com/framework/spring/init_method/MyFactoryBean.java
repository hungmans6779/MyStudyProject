package com.framework.spring.init_method;

public class MyFactoryBean {

  
  public MyFactoryBean(){
    System.out.println(MyFactoryBean.class.getName()+" �غc�l execute");
  } // end
  
  
  
  public void init(){
    System.out.println(MyFactoryBean.class.getName()+" init_method  execute");
  }
  
  
}
