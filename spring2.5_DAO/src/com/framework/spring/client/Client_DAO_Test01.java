package com.framework.spring.client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.dao.IPersonDAO;
import com.framework.spring.entity.Person;

public class Client_DAO_Test01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
   
    // 載入設定檔
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

    // 獲得 Peson DAO 物件
    IPersonDAO personDAO = (IPersonDAO)factory.getBean("personDAOId");
    
    
    
        
    // 產生 Peson 物件
    Person person  = new Person();
    person.setName("kevin"); 
    person.setAge(35);
    person.setSex("男");
    person.setBirthday(new Date());
    
    
    
    
    
    
    
    
    
    
    // 增加 Person 物件
    personDAO.addPerson(person);
    System.out.println("\n\n\n\n\n");
    
    
    
    // 傳回所有Person 的數目 
    int count = personDAO.getPersonCount();
    System.out.println("傳回所有Person 的數目,count = " + count);
    System.out.println("\n\n\n\n\n");
    
    
    
    // 根據 id 獲得Person 姓名   
    int id = 1;
    String name = personDAO.getPersonName(id);
    System.out.println("根據 id = " + id + ",獲得Person 姓名,name = " + name);
    System.out.println("\n\n\n\n\n");
    
    
    
    // 傳回所有的Person 
    List<Person> personList = personDAO.listPersons();
    System.out.println("傳回所有的 personList");
    for(Person p:personList){
      System.out.println("Name："+p.getName());  
    } // end for(Person p:personList){
    System.out.println("\n\n\n\n\n");
    
    
    
    // 傳回所有的 Person
    List<Person> personList1 =  personDAO.findAllPerson();
    System.out.println("傳回所有的 personList1");
    for(Person p:personList1){
      System.out.println("Name："+p.getName());  
    } // end for(Person p:personList){
    System.out.println("\n\n\n\n\n");
    
    
    
    
    // 更新 tb_person 性別 (使用 SqlUpdate)
    int count1 = personDAO.sqlUpdate(17,"女");
    System.out.println("count1 = " + count1);
    System.out.println("\n\n\n\n\n");
    
    
    
    
    // 執行 SpringFramework SqlFunction
    int count2 = personDAO.countRows();
    System.out.println("總筆數 count2 = " + count2);
    System.out.println("\n\n\n\n\n");
    
    
    
  } // end main

  
  
}
