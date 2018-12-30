package com.framework.spring.dao.transaction;

import java.util.Date;
import java.util.List;

import com.framework.spring.dao.IPersonDAO;
import com.framework.spring.entity.Person;


/*
 *  Spring �ϥ� org.springframework.jdbc.datasource.DataSourceTransactionManager �@�� JDBC ������޲z�̡A
 *  �P�ɧ�Q�޲z������ϥ� org.springframework.transaction.interceptor.TransactionProxyFactoryBean �]�w�C
 *  �o�O�@�ӥ���N�z Bean�A����ϥ� IoC�BAOP ���ӤJ����޲z�{���X�C�Ҧp�� TransactionRun �� run() ��k�]�w����C
 */
public class TransactionRun {

  private IPersonDAO personDAO;

  public IPersonDAO getPersonDAO() {
    return personDAO;
  }

  public void setPersonDAO(IPersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  
  
  
  // �D��k�A�� Spring �I�s
  public void run(){
    
    Person person = new Person();
    person.setName("����_��");
    person.setAge(30);
    person.setSex("�k");
    person.setBirthday(new Date());
  
    
    // �W�[ Person ����
    personDAO.addPerson(person);
    System.out.println("\n\n\n\n\n");
    
    
    
    // �Ǧ^�Ҧ�Person ���ƥ� 
    int count = personDAO.getPersonCount();
    System.out.println("count = " + count);
    System.out.println("\n\n\n\n\n");
    
    
    
    // �ھ� id ��oPerson �m�W  
    String name = personDAO.getPersonName(Integer.MAX_VALUE);  // �ߥX�ҥ~���a��
    // String name = personDAO.getPersonName(17);  // �ߥX�ҥ~���a��
    System.out.println("name = "+name);
    System.out.println("\n\n\n\n\n");
    
    
    
    // �Ǧ^�Ҧ���Person(�ĥ�MappingSqlQuery ��)
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
