package com.framework.spring.entity;

import java.util.Date;


/**
 *  POJO �������O�� Person�C
 * 
 *  ���ұN�ϥ� Spring ���Ѫ� JdbcTemplate �N Person ���[�ƪ���Ʈw���A�Ϊ̱N Person �q��Ʈw��Ū���X�ӡC
 */
public class Person {

  private Integer id;        // id
  private String name;       // �m�W
  private String sex;        // �ʧO
  private int age;           // �~�� 
  private Date birthday;    // �ͤ�
  
  
 
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

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  



}
