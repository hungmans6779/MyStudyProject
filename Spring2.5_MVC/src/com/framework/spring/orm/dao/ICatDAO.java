package com.framework.spring.orm.dao;

import java.util.List;

import com.framework.spring.orm.entity.Cat;


/*
 * Cat  DAO ざ
 */
public interface ICatDAO {

  /*
   * 纗ン
   * 
   * @param Cat ン
   */
  public void createCat(Cat cat);


  /*
   * 琩高┮Τン
   * 
   * @return Cat List ン
   */
  public List<Cat> listCats();


  /*
   * 肚ン计秖
   * 
   * @param int 计秖
   */
  public int getCatsCount();


  /*
   * 沮琩高ン
   * 
   * @return Cat ン
   */
  public Cat findCatByName(String name);
  
  
  
}
