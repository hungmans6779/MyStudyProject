package com.framework.spring.dao.jdbcMappingDao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.framework.spring.entity.Person;


/*
 *  MappingSqlQuery �O�@�ө�H���O�A�}�o�̻ݭn�ꥦ�� mapRow(ResultSet,int) ��k��{�q ResultSet �� Java ���󪺬M�g�C
 *  �Ӥ�k�����Ǧ^�������O����C 
 */
public class PersonMappingQuery extends MappingSqlQuery {

  
  // �ʸ�
  @Override
  protected Object mapRow(ResultSet rs, int columnIndex) throws SQLException {
  
    Person person = new Person();                     // ���͹���@�� Person  
    person.setId(rs.getInt("id"));                    // �]�w id
    person.setName(rs.getString("name"));             // �m�W
    person.setSex(rs.getString("sex"));               // �ʧO
    person.setAge(rs.getInt("age"));                  // �~��
    person.setBirthday(rs.getTimestamp("birthday"));  // �X�ͤ��
    
    return person;
  } // end mapRow

  
  
}
