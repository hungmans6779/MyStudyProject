package com.framework.spring.constructor;

public class MyBean {
  
  private AnotherBean bean01 = null;
  private YetAnotherBean bean02 = null;
  private int i = 0;
  
  public MyBean(AnotherBean anotherBean,YetAnotherBean yetAnotherBean,int i){
    this.bean01 = anotherBean;
    this.bean02 =  yetAnotherBean;
    this.i = i;
  }

  
  
  
  public AnotherBean getBean01() {
    return bean01;
  }

  public YetAnotherBean getBean02() {
    return bean02;
  }

  public int getI() {
    return i;
  }
  
  

  
}
