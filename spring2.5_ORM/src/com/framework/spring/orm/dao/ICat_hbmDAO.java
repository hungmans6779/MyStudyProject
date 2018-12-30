package com.framework.spring.orm.dao;

import java.util.List;

import com.framework.spring.orm.entity.Cat_hbm;


/*
 * Cat_hbm  DAO ざ
 */
public interface ICat_hbmDAO {

  /*
   * 纗ン
   * 
   * @param Cat ン
   */
  public void createCat(Cat_hbm cat);


  /*
   * 琩高┮Τン
   * 
   * @return Cat List ン
   */
  public List<Cat_hbm> listCats();


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
  public Cat_hbm findCatByName(String name);
  
  
}
