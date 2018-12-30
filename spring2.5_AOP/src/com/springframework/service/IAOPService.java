package com.springframework.service;

public interface IAOPService {
 
  // 會被攔截
  public void withAOP() throws Exception;
  
  // 不會被攔截 
  public void withoutAOP() throws Exception;

}
