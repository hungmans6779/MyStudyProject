package com.framework.spring.autowire.entity;

import com.framework.spring.autowire.dao.DaoImpl;

public class MyFactoryBeanA {
  
  public DaoImpl daoImpl;

  public DaoImpl getDaoImpl() {
    return daoImpl;
  }

  public void setDaoImpl(DaoImpl daoImpl) {
    this.daoImpl = daoImpl;
  }


  
  public void serviceA(String msg) {
    System.out.println(MyFactoryBeanA.class.getName()+ ","+daoImpl.sayHello(msg));
  }


}
