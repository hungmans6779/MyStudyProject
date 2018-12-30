package com.framework.spring.orm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.framework.spring.orm.dao.ICatDAO;
import com.framework.spring.orm.entity.Cat;


/*
 *  實現 ICatDao 介面
 *  
 *  
 *  在 Spring 裡， Hiberate 的資源要交給 Spring 管理。 Hibernate 及其 SessionFactory 等只是 Spring 一個特殊的 Bean ，
 *  由 Spring 負責產生實體與銷毀。因此，DAO 層只要繼承 org.springframework.orm.hibernate3.support.HibernateDaoSupport ，
 *  而不需要與 Hibernate 的 API 打交道，不需要開啟、關閉 Hibernate 的 Session、Transaction 、Spring 會自動維護這些物件。
 */
public class CatDAOImpl extends HibernateDaoSupport implements ICatDAO {

  
  
  /*
   * 儲存物件
   * 
   * @param Cat 物件
   */
  public void createCat(Cat cat) {
    this.getHibernateTemplate().persist(cat);  // 使用 HiberateTemplate 儲存
  } // end create

  
  
  
  /*
   * 查詢所有物件
   * 
   * @return Cat List 物件
   */
  public List<Cat> listCats() {
    
    List<Cat> list = this.getHibernateTemplate().find("SELECT c FROM Cat c");
    
    return list;
  } // end listCats()

  
  
  
  
  /*
   * 傳回物件數量
   * 
   * @param int 數量
   */
  public int getCatsCount() {

    Number num = (Number)this.getSession(true).createQuery("SELECT count(c) FROM Cat c").uniqueResult();
    
    return num.intValue();
  } // end getCatsCount()

  
  
  
  
  /*
   * 根據名字查詢物件(根據名字查詢Cat)
   * 
   * @return Cat 物件
   */
  public Cat findCatByName(String name) {

    List<Cat> catList = this.getHibernateTemplate().find("SELECT c FROM Cat c WHERE c.name = ? ",name);
    
    if(catList.size() > 0){
      return catList.get(0);   // 傳回第一條 
    } else {
      return null;
    }
   
  } // end findCatByName

  
  
  
  
}
