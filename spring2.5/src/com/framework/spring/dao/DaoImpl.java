package com.framework.spring.dao;

import java.util.Calendar;

public class DaoImpl implements IDao {

  public String sayHello(String name) {
    
    int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    
    if(hour < 6)  { return "���n," +name; }
    if(hour < 12) { return "���W�n," +name; }
    if(hour < 13) { return "���Ȧn," +name; }
    if(hour < 18) { return "�U�Ȧn," +name; }
    
    return "�ߤW�n," +name;
  } // end sayHello

}
