package com.framework.spring.orm.service.impl;

import java.util.List;

import com.framework.spring.orm.dao.ICatDAO;
import com.framework.spring.orm.entity.Cat;
import com.framework.spring.orm.service.ICatService;


/*
 *  Service ざ
 *  
 *  Spring 箇砞 DAO 糷糤ユDAO 糷–よ猭ユ 
 *  Spring + Hibernate 祘Α砞璸い策篋暗猭琌 DAO 糷糤 Service 糷
 *  礛рユ砞﹚ Service 糷
 */
public class CatServiceImpl implements ICatService {

  // 篶
  public CatServiceImpl() {
  }
  
  
  // Cat DAO ン
  private ICatDAO catDAO;
  
  
  
  
  public ICatDAO getCatDAO() {
    return catDAO;
  }



  public void setCatDAO(ICatDAO catDAO) {
    this.catDAO = catDAO;
  }


  
  
  /*
   *  纗 Cat ン
   *  @param Cat ン
   */
  public void createCat(Cat cat) {
 
    Cat catObj = catDAO.findCatByName(cat.getName());
    if(catObj!=null){
      throw new RuntimeException("窟 => " + cat.getName() +" , ");
    }
    
    catDAO.createCat(cat);
  
  } // end createCat
  
  
  

  
  /*
   *  ┮Τ Cat
   *  @return List Cat ン 
   */
  public List<Cat> listCats() {

    return catDAO.listCats();
  } // end listCats
  
  

  
  /*
   *  琩高 Cat 计秖
   *  @return int Cat 计秖
   */
  public int getCatsCount() {

    return catDAO.getCatsCount();
  } // end getCatsCount() 

  
  
  
}
