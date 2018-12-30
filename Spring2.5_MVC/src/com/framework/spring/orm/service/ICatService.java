package com.framework.spring.orm.service;

import java.util.List;

import com.framework.spring.orm.entity.Cat;


/*
 *  Service ����
 *  
 *  Spring �w�]�b DAO �h�W�[����ADAO �h���C�Ӥ�k���@�ӥ���C 
 *  Spring + Hibernate �{���]�p���A�ߺD�����k�O�b DAO �h�W�A�W�[�@�� Service �h�A
 *  �M������]�w�b Service �h�W�C
 */
public interface ICatService {

  /*
   *  �x�s Cat ����
   *  @param Cat ����
   */
  public void createCat(Cat cat);
  
  
  /*
   *  �C�X�Ҧ� Cat
   *  @return List Cat ���� 
   */
  public List<Cat> listCats();
  
  
  /*
   *  �d�� Cat �ƶq
   *  @return int Cat �ƶq
   */
  public int getCatsCount();
  
  
  
}
