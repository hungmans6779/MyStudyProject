package com.framework.spring.orm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.framework.spring.orm.dao.ICat_hbmDAO;
import com.framework.spring.orm.entity.Cat_hbm;





/*
 *  ��{ ICatDao ����
 *  
 *  
 *  �b Spring �̡A Hiberate ���귽�n�浹 Spring �޲z�C Hibernate �Ψ� SessionFactory ���u�O Spring �@�ӯS�� Bean �A
 *  �� Spring �t�d���͹���P�P���C�]���ADAO �h�u�n�~�� org.springframework.orm.hibernate3.support.HibernateDaoSupport �A
 *  �Ӥ��ݭn�P Hibernate �� API ����D�A���ݭn�}�ҡB���� Hibernate �� Session�BTransaction �BSpring �|�۰ʺ��@�o�Ǫ���C
 */
public class Cat_hbmDAOImpl extends HibernateDaoSupport implements ICat_hbmDAO {

  
  
  /*
   * �x�s����
   * 
   * @param Cat ����
   */
  public void createCat(Cat_hbm cat_hbm) {
    this.getHibernateTemplate().persist(cat_hbm);  // �ϥ� HiberateTemplate �x�s
  } // end create

  
  
  
  /*
   * �d�ߩҦ�����
   * 
   * @return Cat List ����
   */
  public List<Cat_hbm> listCats() {
    
    List<Cat_hbm> list = this.getHibernateTemplate().find("SELECT c FROM Cat_hbm c");
    
    return list;
  } // end listCats()

  
  
  
  
  /*
   * �Ǧ^����ƶq
   * 
   * @param int �ƶq
   */
  public int getCatsCount() {

    Number num = (Number)this.getSession(true).createQuery("SELECT count(c) FROM Cat_hbm c").uniqueResult();
    
    return num.intValue();
  } // end getCatsCount()

  
  
  
  
  /*
   * �ھڦW�r�d�ߪ���(�ھڦW�r�d��Cat)
   * 
   * @return Cat ����
   */
  public Cat_hbm findCatByName(String name) {

    List<Cat_hbm> catList = this.getHibernateTemplate().find("SELECT c FROM Cat_hbm c WHERE c.name = ? ",name);
    
    if(catList.size() > 0){
      return catList.get(0);   // �Ǧ^�Ĥ@�� 
    } else {
      return null;
    }
   
  } // end findCatByName

  
  
  
  
}
