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
    
    
    
    // �إ� Cat ����
    Cat cat = new Cat();
    cat.setName("kevin's 01 cat");
    cat.setCreateDate(new Date());
    
    
    // �x�s����
    catDao.createCat(cat);
    System.out.println("\n");
    
    

    // �d�ߩҦ� Cat ����
    List<Cat> listCat = catDao.listCats();
    for(Cat c:listCat){
      System.out.println("id         = " + c.getId()); 
      System.out.println("name       = " + c.getName()); 
      System.out.println("createDate = " + c.getCreateDate()); 
    }
    System.out.println("\n");
    
    
    
    // �Ǧ^ Cat ����ƶq
    int count = catDao.getCatsCount();
    System.out.println("���o�`���� count�G"+count);
    System.out.println("\n");
    
    
    
    // �ھڦW�r�d�ߪ���(�ھڦW�r�d��Cat)
    Cat catObj = catDao.findCatByName("kevin's 01 cat");
    System.out.println("catObj name = "+catObj.getName());
    System.out.println("\n");
    
    
    
  } // end main
  
  

}
