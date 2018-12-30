package com.framework.spring.orm.service.impl;

import java.util.List;

import com.framework.spring.orm.dao.ICatDAO;
import com.framework.spring.orm.entity.Cat;
import com.framework.spring.orm.service.ICatService;


/*
 *  Service ����
 *  
 *  Spring �w�]�b DAO �h�W�[����ADAO �h���C�Ӥ�k���@�ӥ���C 
 *  Spring + Hibernate �{���]�p���A�ߺD�����k�O�b DAO �h�W�A�W�[�@�� Service �h�A
 *  �M������]�w�b Service �h�W�C
 */
public class CatServiceImpl implements ICatService {

  // �غc�l
  public CatServiceImpl() {
  }
  
  
  // Cat DAO ����
  private ICatDAO catDAO;
  
  
  
  
  public ICatDAO getCatDAO() {
    return catDAO;
  }



  public void setCatDAO(ICatDAO catDAO) {
    this.catDAO = catDAO;
  }


  
  
  /*
   *  �x�s Cat ����
   *  @param Cat ����
   */
  public void createCat(Cat cat) {
 
    Cat catObj = catDAO.findCatByName(cat.getName());
    if(catObj!=null){
      throw new RuntimeException("�� => " + cat.getName() +" , �w�s�b");
    }
    
    catDAO.createCat(cat);
  
  } // end createCat
  
  
  

  
  /*
   *  �C�X�Ҧ� Cat
   *  @return List Cat ���� 
   */
  public List<Cat> listCats() {

    return catDAO.listCats();
  } // end listCats
  
  

  
  /*
   *  �d�� Cat �ƶq
   *  @return int Cat �ƶq
   */
  public int getCatsCount() {

    return catDAO.getCatsCount();
  } // end getCatsCount() 

  
  
  
}
