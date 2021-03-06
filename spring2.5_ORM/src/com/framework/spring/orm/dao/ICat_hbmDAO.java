package com.framework.spring.orm.dao;

import java.util.List;

import com.framework.spring.orm.entity.Cat_hbm;


/*
 * Cat_hbm 的 DAO 介面
 */
public interface ICat_hbmDAO {

  /*
   * 儲存物件
   * 
   * @param Cat 物件
   */
  public void createCat(Cat_hbm cat);


  /*
   * 查詢所有物件
   * 
   * @return Cat List 物件
   */
  public List<Cat_hbm> listCats();


  /*
   * 傳回物件數量
   * 
   * @param int 數量
   */
  public int getCatsCount();


  /*
   * 根據名字查詢物件
   * 
   * @return Cat 物件
   */
  public Cat_hbm findCatByName(String name);
  
  
}
