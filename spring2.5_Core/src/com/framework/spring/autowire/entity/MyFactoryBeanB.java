package com.framework.spring.autowire.entity;

import com.framework.spring.autowire.dao.DaoImpl;

public class MyFactoryBeanB {

  public DaoImpl daoImpl;

  public DaoImpl getDaoImpl() {
    return daoImpl;
  }

  public void setDaoImpl(DaoImpl daoImpl) {
    this.daoImpl = daoImpl;
  }
  
  
  
  public void serviceB(String msg){
    System.out.println(MyFactoryBeanB.class.getName()+ ","+daoImpl.sayHello(msg));
  }
  
  
  
  
}
