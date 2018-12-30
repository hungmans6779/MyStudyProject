package com.framework.spring.orm.dao;

import java.util.List;

import com.framework.spring.orm.entity.Cat;


/*
 * Cat �� DAO ����
 */
public interface ICatDAO {

  /*
   * �x�s����
   * 
   * @param Cat ����
   */
  public void createCat(Cat cat);


  /*
   * �d�ߩҦ�����
   * 
   * @return Cat List ����
   */
  public List<Cat> listCats();


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
  public Cat findCatByName(String name);
  
  
  
}
