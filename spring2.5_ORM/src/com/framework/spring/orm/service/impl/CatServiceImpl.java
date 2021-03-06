package com.framework.spring.orm.service.impl;

import java.util.List;

import com.framework.spring.orm.dao.ICatDAO;
import com.framework.spring.orm.entity.Cat;
import com.framework.spring.orm.service.ICatService;


/*
 *  Service 介面
 *  
 *  Spring 預設在 DAO 層增加交易，DAO 層的每個方法為一個交易。 
 *  Spring + Hibernate 程式設計中，習慣的做法是在 DAO 層上再增加一個 Service 層，
 *  然後把交易設定在 Service 層上。
 */
public class CatServiceImpl implements ICatService {

  // 建構子
  public CatServiceImpl() {
  }
  
  
  // Cat DAO 物件
  private ICatDAO catDAO;
  
  
  
  
  public ICatDAO getCatDAO() {
    return catDAO;
  }



  public void setCatDAO(ICatDAO catDAO) {
    this.catDAO = catDAO;
  }


  
  
  /*
   *  儲存 Cat 物件
   *  @param Cat 物件
   */
  public void createCat(Cat cat) {
 
    Cat catObj = catDAO.findCatByName(cat.getName());
    if(catObj!=null){
      throw new RuntimeException("貓 => " + cat.getName() +" , 已存在");
    }
    
    catDAO.createCat(cat);
  
  } // end createCat
  
  
  

  
  /*
   *  列出所有 Cat
   *  @return List Cat 物件 
   */
  public List<Cat> listCats() {

    return catDAO.listCats();
  } // end listCats
  
  

  
  /*
   *  查詢 Cat 數量
   *  @return int Cat 數量
   */
  public int getCatsCount() {

    return catDAO.getCatsCount();
  } // end getCatsCount() 

  
  
  
}
