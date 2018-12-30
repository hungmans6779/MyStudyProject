package com.framework.spring.orm.client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.orm.dao.ICatDAO;
import com.framework.spring.orm.entity.Cat;
import com.framework.spring.orm.service.ICatService;

public class Client {

  public static void main(String[] args){
     
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

    ICatService catService = (ICatService)factory.getBean("catServiceBean");
    

    Cat cat = new Cat();
    cat.setName("kevin's ");
    cat.setCreateDate(new Date());
    
    // 儲存 Cat 物件
    catService.createCat(cat);
    
    // 查詢 Cat 數量
    int count = catService.getCatsCount();
    System.out.println("count = " + count);
    
    List<Cat> catList = catService.listCats();
    for(Cat c : catList){
      System.out.println("id         = " + c.getId());
      System.out.println("name       = " + c.getName());
      System.out.println("createDate = " + c.getCreateDate());

      System.out.println("\n");
    } // end  for(Cat c : catList){
 
    
    
  } // end main
  
  
  
  
}
