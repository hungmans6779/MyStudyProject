package com.framework.spring.dao;

import java.util.List;

import org.springframework.jdbc.object.SqlFunction;

import com.framework.spring.entity.Person;

/**
 *  Person �� DAO ����
 */
public interface IPersonDAO {

  /**
   *  �ھ� id ��oPerson �m�W   
   */
  public String getPersonName(Integer id);
  
  /**
   *  �W�[ Person ����
   */
  public void addPerson(Person person);
  
  
  /**
   *  �Ǧ^�Ҧ�Person ���ƥ� 
   */
  public int getPersonCount();
  
  
  /**
   *  �Ǧ^�Ҧ���Person 
   */
  public List<Person> listPersons();
  
  
  /**
   *  �Ǧ^�Ҧ���Person(�ĥ�MappingSqlQuery ��)
   */
  public List<Person> findAllPerson();
  
  
  
  /**
   *  ��s tb_person �ʧO (�ϥ� SqlUpdate)
   */
  public int sqlUpdate(Integer id,String sex);
  
  
  
  /**
   *   ���� SpringFramework SqlFunction 
   */
  public int countRows();
  
  
  
}
