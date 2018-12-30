package com.framework.spring.service;

import com.framework.spring.dao.IDao;

public class ServiceImpl implements IService {

  private IDao dao;

  public IDao getDao() {
    return dao;
  }

  public void setDao(IDao dao) {
    this.dao = dao;
  }


  

  public void service(String name) {
    System.out.println(dao.sayHello(name));
  }

  
  public void serviceType(String type,String name){
    System.out.println("«¬§O type = " +type + " ,name = " + dao.sayHello(name));    
  }

  
}
