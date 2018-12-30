package com.framework.spring.destoryBean;

public class DestroyBean02 {
  
  private String message;
  
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  
  public void destroy() throws Exception {
    System.out.println(DestroyBean02.class.getName() + " ,destroy() execute ... ");
  }

  
  
  public void showInfo(){
    System.out.println(DestroyBean02.class.getName() + " ,showInfo() execute ...");
    System.out.println("message = " + message);
  }
  
  
  
}
