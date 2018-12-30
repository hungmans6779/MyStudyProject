package com.framework.spring.orm.client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.orm.dao.ICatDAO;
import com.framework.spring.orm.entity.Cat;

public class Client_ORM_class {

  /**
   * @param args
   */
  public static void main(String[] args) {
  
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_orm_1.xml"));

    ICatDAO catDao = (ICatDAO)factory.getBean("catDAOBean");
    
    
    
    // ミ Cat ン
    Cat cat = new Cat();
    cat.setName("kevin's 01 cat");
    cat.setCreateDate(new Date());
    
    
    // 纗ン
    catDao.createCat(cat);
    System.out.println("\n");
    
    

    // 琩高┮Τ Cat ン
    List<Cat> listCat = catDao.listCats();
    for(Cat c:listCat){
      System.out.println("id         = " + c.getId()); 
      System.out.println("name       = " + c.getName()); 
      System.out.println("createDate = " + c.getCreateDate()); 
    }
    System.out.println("\n");
    
    
    
    // 肚 Cat ン计秖
    int count = catDao.getCatsCount();
    System.out.println("眔羆掸计 count"+count);
    System.out.println("\n");
    
    
    
    // 沮琩高ン(沮琩高Cat)
    Cat catObj = catDao.findCatByName("kevin's 01 cat");
    System.out.println("catObj name = "+catObj.getName());
    System.out.println("\n");
    
    
    
  } // end main
  
  

}
