package com.springframework.service.impl;

import javax.security.auth.login.AccountException;

import com.springframework.service.IAOPService;


/*
 *  實作 IAopService 的介面
 */
public class AOPServiceImpl implements IAOPService {

  
  private String name;
  
  
  public String getName() {
    return name;
  }
 
  
  public void setName(String name) {
    this.name = name;
    System.out.println(AOPServiceImpl.class.getName()+" setName() execute ...");
    System.out.println("name = " + name);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  // 會被攔截
  public void withAOP() throws Exception {
    
    System.out.println("\n");
    System.out.println(AOPServiceImpl.class.getName() + " withAOP() execute ...");
    System.out.println("《有》 AOP 的函數執行。name = " + name);
    System.out.println("\n");
    
    if(name.trim().length() == 0){
      throw new AccountException("name 屬性不能為空");
    }
    
  } // end withAOP() 

  
  
  
  // 不會被攔截 
  public void withoutAOP() throws Exception {
    
    System.out.println("\n");
    System.out.println(AOPServiceImpl.class.getName() + " withoutAOP() execute ...");
    System.out.println("《沒有》 AOP 的函數執行。name = " + name);
    System.out.println("\n"); 
    
    if(name.trim().length() == 0){
      throw new AccountException("name 屬性不能為空");
    }
    
  } // end withoutAOP()

  
  
  
  
}
