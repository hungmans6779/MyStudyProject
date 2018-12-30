package com.framework.spring.orm.dao;

import java.util.List;

import com.framework.spring.orm.entity.Cat_hbm;


/*
 * Cat_hbm �� DAO ����
 */
public interface ICat_hbmDAO {

  /*
   * �x�s����
   * 
   * @param Cat ����
   */
  public void createCat(Cat_hbm cat);


  /*
   * �d�ߩҦ�����
   * 
   * @return Cat List ����
   */
  public List<Cat_hbm> listCats();


  /*
   * �Ǧ^����ƶq
   * 
   * @param int �ƶq
   */
  public int getCatsCount();


  /*
   * �ھڦW�r�d�ߪ���
   * 
   * @return Cat ����
   */
  public Cat_hbm findCatByName(String name);
  
  
}
