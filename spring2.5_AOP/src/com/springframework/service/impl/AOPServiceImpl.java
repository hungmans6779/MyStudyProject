package com.springframework.service.impl;

import javax.security.auth.login.AccountException;

import com.springframework.service.IAOPService;


/*
 *  ��@ IAopService ������
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
  
  
  
  
  
  
  
  
  
  
  
  
  
  // �|�Q�d�I
  public void withAOP() throws Exception {
    
    System.out.println("\n");
    System.out.println(AOPServiceImpl.class.getName() + " withAOP() execute ...");
    System.out.println("�m���n AOP ����ư���Cname = " + name);
    System.out.println("\n");
    
    if(name.trim().length() == 0){
      throw new AccountException("name �ݩʤ��ର��");
    }
    
  } // end withAOP() 

  
  
  
  // ���|�Q�d�I 
  public void withoutAOP() throws Exception {
    
    System.out.println("\n");
    System.out.println(AOPServiceImpl.class.getName() + " withoutAOP() execute ...");
    System.out.println("�m�S���n AOP ����ư���Cname = " + name);
    System.out.println("\n"); 
    
    if(name.trim().length() == 0){
      throw new AccountException("name �ݩʤ��ର��");
    }
    
  } // end withoutAOP()

  
  
  
  
}
