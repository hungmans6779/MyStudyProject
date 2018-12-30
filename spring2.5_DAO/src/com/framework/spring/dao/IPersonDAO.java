package com.framework.spring.dao;

import java.util.List;

import org.springframework.jdbc.object.SqlFunction;

import com.framework.spring.entity.Person;

/**
 *  Person 的 DAO 介面
 */
public interface IPersonDAO {

  /**
   *  根據 id 獲得Person 姓名   
   */
  public String getPersonName(Integer id);
  
  /**
   *  增加 Person 物件
   */
  public void addPerson(Person person);
  
  
  /**
   *  傳回所有Person 的數目 
   */
  public int getPersonCount();
  
  
  /**
   *  傳回所有的Person 
   */
  public List<Person> listPersons();
  
  
  /**
   *  傳回所有的Person(採用MappingSqlQuery 的)
   */
  public List<Person> findAllPerson();
  
  
  
  /**
   *  更新 tb_person 性別 (使用 SqlUpdate)
   */
  public int sqlUpdate(Integer id,String sex);
  
  
  
  /**
   *   執行 SpringFramework SqlFunction 
   */
  public int countRows();
  
  
  
}
