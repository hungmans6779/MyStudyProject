package com.framework.spring.orm.client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.orm.dao.ICat_hbmDAO;
import com.framework.spring.orm.entity.Cat_hbm;

public class Client_ORM_hbm {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_orm_2.xml"));

    ICat_hbmDAO catDao = (ICat_hbmDAO)factory.getBean("catDAOBean");
    
    
    
    // ミ Cat ン
    Cat_hbm cat = new Cat_hbm();
    cat.setName("kevin's 01 cat");
    cat.setCreateDate(new Date());
    
    
    // 纗ン
    catDao.createCat(cat);
    System.out.println("\n");
    
    

    // 琩高┮Τ Cat ン
    List<Cat_hbm> listCat = catDao.listCats();
    for(Cat_hbm c:listCat){
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
    Cat_hbm catObj = catDao.findCatByName("kevin's 01 cat");
    System.out.println("catObj name = "+catObj.getName());
    System.out.println("\n");
    
    

  }

}
