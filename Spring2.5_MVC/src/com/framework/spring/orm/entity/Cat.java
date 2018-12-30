package com.framework.spring.orm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * ���ұN�ϥ� Spring �� ORM �Ҳ��x�s�AŪ��Cat �������O�C �������O Cat �]�t�@�ӥD��B�@��name �ݩʡB�@�Ӥ���ݩʡA�å� @�����]�w�C
 */
@Entity
@Table(name = "tb_cat")
public class Cat {

  @Id                                            // �D��]�w
  @GeneratedValue(strategy=GenerationType.AUTO)  // �D��W�h�]�w
  private Integer id;
  
 
  private String name;                          // �ϥιw�]�]�w
  
  
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date createDate;                      // �C������ timestamp

  
  

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public Date getCreateDate() {
    return createDate;
  }


  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }



}
