package com.framework.spring.orm.client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.orm.entity.Cat;
import com.framework.spring.orm.service.ICatService;

public class Client_Transaction {

  /**
   * @param args
   */
  public static void main(String[] args) {
   
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_transaction.xml"));

    ICatService catService = (ICatService)factory.getBean("catServiceBean");
   
    Cat cat = new Cat();
    cat.setName("kevin's");
    cat.setCreateDate(new Date());
    
    
    // �x�s Cat ����
    catService.createCat(cat);
    System.out.println("\n");
   
    // �d�� Cat �ƶq
    int count = catService.getCatsCount();
    System.out.println("cat count = " + count);
    System.out.println("\n");
    
    // �C�X�Ҧ� Cat
    List<Cat> catList = catService.listCats();
    for(Cat c:catList){
      System.out.println("id         = " + c.getId());
      System.out.println("name       = " + c.getName());
      System.out.println("createDate = " + c.getCreateDate());
      
      System.out.println("\n");
    } // end for(Cat c:catList){
    
    
  } // end main
  
  
  

}
