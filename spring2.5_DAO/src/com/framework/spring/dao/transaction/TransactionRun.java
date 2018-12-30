package com.framework.spring.dao.transaction;

import java.util.Date;
import java.util.List;

import com.framework.spring.dao.IPersonDAO;
import com.framework.spring.entity.Person;


/*
 *  Spring 使用 org.springframework.jdbc.datasource.DataSourceTransactionManager 作為 JDBC 的交易管理者，
 *  同時把被管理的物件使用 org.springframework.transaction.interceptor.TransactionProxyFactoryBean 設定。
 *  這是一個交易代理 Bean，能夠使用 IoC、AOP 等植入交易管理程式碼。例如為 TransactionRun 的 run() 方法設定交易。
 */
public class TransactionRun {

  private IPersonDAO personDAO;

  public IPersonDAO getPersonDAO() {
    return personDAO;
  }

  public void setPersonDAO(IPersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  
  
  
  // 主方法，供 Spring 呼叫
  public void run(){
    
    Person person = new Person();
    person.setName("交易復原");
    person.setAge(30);
    person.setSex("男");
    person.setBirthday(new Date());
  
    
    // 增加 Person 物件
    personDAO.addPerson(person);
    System.out.println("\n\n\n\n\n");
    
    
    
    // 傳回所有Person 的數目 
    int count = personDAO.getPersonCount();
    System.out.println("count = " + count);
    System.out.println("\n\n\n\n\n");
    
    
    
    // 根據 id 獲得Person 姓名  
    String name = personDAO.getPersonName(Integer.MAX_VALUE);  // 拋出例外的地方
    // String name = personDAO.getPersonName(17);  // 拋出例外的地方
    System.out.println("name = "+name);
    System.out.println("\n\n\n\n\n");
    
    
    
    // 傳回所有的Person(採用MappingSqlQuery 的)
    List<Person> personList = personDAO.findAllPerson();
    for(Person p:personList){
      System.out.println("id       = " + p.getId());
      System.out.println("name     = " + p.getName());
      System.out.println("age      = " + p.getAge());
      System.out.println("sex      = " + p.getSex());
      System.out.println("birthday = " + p.getBirthday());
      
      System.out.println("\n");
    } // end for(Person p:personList){
    System.out.println("\n\n\n\n\n");
    
    
  } // end run
  
  
  
  
  
  
}
