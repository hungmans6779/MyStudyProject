package com.framework.spring.orm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.framework.spring.orm.dao.ICatDAO;
import com.framework.spring.orm.entity.Cat;


/*
 *  ��{ ICatDao ����
 *  
 *  
 *  �b Spring �̡A Hiberate ���귽�n�浹 Spring �޲z�C Hibernate �Ψ� SessionFactory ���u�O Spring �@�ӯS�� Bean �A
 *  �� Spring �t�d���͹���P�P���C�]���ADAO �h�u�n�~�� org.springframework.orm.hibernate3.support.HibernateDaoSupport �A
 *  �Ӥ��ݭn�P Hibernate �� API ����D�A���ݭn�}�ҡB���� Hibernate �� Session�BTransaction �BSpring �|�۰ʺ��@�o�Ǫ���C
 */
public class CatDAOImpl extends HibernateDaoSupport implements ICatDAO {

  
  
  /*
   * �x�s����
   * 
   * @param Cat ����
   */
  public void createCat(Cat cat) {
    this.getHibernateTemplate().persist(cat);  // �ϥ� HiberateTemplate �x�s
  } // end create

  
  
  
  /*
   * �d�ߩҦ�����
   * 
   * @return Cat List ����
   */
  public List<Cat> listCats() {
    
    List<Cat> list = this.getHibernateTemplate().find("SELECT c FROM Cat c");
    
    return list;
  } // end listCats()

  
  
  
  
  /*
   * �Ǧ^����ƶq
   * 
   * @param int �ƶq
   */
  public int getCatsCount() {

    Number num = (Number)this.getSession(true).createQuery("SELECT count(c) FROM Cat c").uniqueResult();
    
    return num.intValue();
  } // end getCatsCount()

  
  
  
  
  /*
   * �ھڦW�r�d�ߪ���(�ھڦW�r�d��Cat)
   * 
   * @return Cat ����
   */
  public Cat findCatByName(String name) {

    List<Cat> catList = this.getHibernateTemplate().find("SELECT c FROM Cat c WHERE c.name = ? ",name);
    
    if(catList.size() > 0){
      return catList.get(0);   // �Ǧ^�Ĥ@�� 
    } else {
      return null;
    }
   
  } // end findCatByName

  
  
  
  
}
