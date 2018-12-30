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
   
    // ���J�]�w��
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

    // ��o Peson DAO ����
    IPersonDAO personDAO = (IPersonDAO)factory.getBean("personDAOId");
    
    
    
        
    // ���� Peson ����
    Person person  = new Person();
    person.setName("kevin"); 
    person.setAge(35);
    person.setSex("�k");
    person.setBirthday(new Date());
    
    
    
    
    
    
    
    
    
    
    // �W�[ Person ����
    personDAO.addPerson(person);
    System.out.println("\n\n\n\n\n");
    
    
    
    // �Ǧ^�Ҧ�Person ���ƥ� 
    int count = personDAO.getPersonCount();
    System.out.println("�Ǧ^�Ҧ�Person ���ƥ�,count = " + count);
    System.out.println("\n\n\n\n\n");
    
    
    
    // �ھ� id ��oPerson �m�W   
    int id = 1;
    String name = personDAO.getPersonName(id);
    System.out.println("�ھ� id = " + id + ",��oPerson �m�W,name = " + name);
    System.out.println("\n\n\n\n\n");
    
    
    
    // �Ǧ^�Ҧ���Person 
    List<Person> personList = personDAO.listPersons();
    System.out.println("�Ǧ^�Ҧ��� personList");
    for(Person p:personList){
      System.out.println("Name�G"+p.getName());  
    } // end for(Person p:personList){
    System.out.println("\n\n\n\n\n");
    
    
    
    // �Ǧ^�Ҧ��� Person
    List<Person> personList1 =  personDAO.findAllPerson();
    System.out.println("�Ǧ^�Ҧ��� personList1");
    for(Person p:personList1){
      System.out.println("Name�G"+p.getName());  
    } // end for(Person p:personList){
    System.out.println("\n\n\n\n\n");
    
    
    
    
    // ��s tb_person �ʧO (�ϥ� SqlUpdate)
    int count1 = personDAO.sqlUpdate(17,"�k");
    System.out.println("count1 = " + count1);
    System.out.println("\n\n\n\n\n");
    
    
    
    
    // ���� SpringFramework SqlFunction
    int count2 = personDAO.countRows();
    System.out.println("�`���� count2 = " + count2);
    System.out.println("\n\n\n\n\n");
    
    
    
  } // end main

  
  
}
