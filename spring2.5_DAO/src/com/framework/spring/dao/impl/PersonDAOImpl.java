package com.framework.spring.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.SqlFunction;

import com.framework.spring.dao.IPersonDAO;
import com.framework.spring.dao.jdbcMappingDao.PersonMappingQuery;
import com.framework.spring.dao.jdbcMappingDao.UpdateCreditRating;
import com.framework.spring.entity.Person;


/**
 *  ��@ Person �� DAO ����
 *  
 *  �~�� Spring �� DAO �Ҳդ���  JdbcDaoSupport ���O�C  JdbcDaoSupport ���ѤF JdbcTemplate ����A�ʸˤF�`�Ϊ� JDBC �ާ@�C
 *  PersonDaoImpl ���٩w�q�F�@�Ӫ�l�Ƥ�k�A�Ω��l�ƪ��c(�p�G���s�b�h�إ�)�C
 *  
 *  �ѩ�{���X�����~�ӤF Spring ���Ѫ� JdbcDaoSupport�A�]���S���ϥ� Connection�B Statement �� JDBC API�A�]���������o�Ǹ귽�C
 *  JdbcDaoSupport �|�۰ʺ��@�o�Ǹ귽�C
 *  �{���X���� Spring �ʸ˦n�� JdbcTemplate �Ӱ��� SQL�B�d�� Person �M��B�d�߳�@ Person �ݩʭȡB�d�� Person ���`�ơC
 *  �d�� Person �C��ɶǦ^���O�@�� List<Map<String,Object>> ������ơC  
 */
public class PersonDAOImpl extends JdbcDaoSupport implements IPersonDAO {

  
  
  
  public void initDataBase(){
    System.out.println(PersonDAOImpl.class.getName() + ", initDataBase Method execute ...");
    
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append(" create table if not exists tb_person      \n");  
    sqlStr.append("  (                                        \n");  
    sqlStr.append("    id int auto_increment,                 \n");
    sqlStr.append("    name varchar(255),                     \n");  
    sqlStr.append("    sex varchar(10),                       \n");  
    sqlStr.append("    age int,                               \n");  
    sqlStr.append("    birthday timestamp,                    \n");  
    sqlStr.append("    primary key (id)                       \n");  
    sqlStr.append("  )                                        \n");  
    System.out.println(PersonDAOImpl.class.getName() + " , initDataBase SQL �y�k \n" + sqlStr.toString());
    
    
    
    getJdbcTemplate().execute(sqlStr.toString());
  } // end initDataBase()
  

  
  
  
  
  
  
  /**
   *  �ھ� id ��oPerson �m�W   
   */
  public String getPersonName(Integer id) {
    System.out.println(PersonDAOImpl.class.getName() + ", getPersonName Method execute ...");
    
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  select name        \n");
    sqlStr.append("    from tb_person   \n");
    sqlStr.append("   where id = ?      \n");
    System.out.println(PersonDAOImpl.class.getName() + " , getPersonName SQL �y�k \n" + sqlStr.toString());
    
    
    String name = (String)getJdbcTemplate().queryForObject(sqlStr.toString(), new Object[]{id}, String.class);
    
    return name;
  } // end getPersonName
  

  
  
  
  
  
  
  /**
   *  �W�[ Person ����
   */
  public void addPerson(Person person) {
    System.out.println(PersonDAOImpl.class.getName() + ", addPerson Method execute ...");
    
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  insert into tb_person                 \n");
    sqlStr.append("         (name, sex,  age,  birthday)   \n");
    sqlStr.append("   values                               \n");
    sqlStr.append("         (?,    ?,    ?,    ?)          \n");
    System.out.println(PersonDAOImpl.class.getName() + " , addPerson SQL �y�k \n" + sqlStr.toString());
   
    
    getJdbcTemplate().update(sqlStr.toString(),new Object[]{
                                                            person.getName(),
                                                            person.getSex(),
                                                            person.getAge(),
                                                            person.getBirthday() 
                                                           });
    
  } // end addPerson
  

  
  
  
  
  
  
  /**
   *  �Ǧ^�Ҧ�Person ���ƥ� 
   */
  public int getPersonCount() {
    System.out.println(PersonDAOImpl.class.getName() + ", getPersonCount Method execute ...");
    
    StringBuffer sqlStr = new StringBuffer("select count(*) from tb_person ");
    System.out.println(PersonDAOImpl.class.getName() + " , getPersonCount SQL �y�k \n" + sqlStr.toString());
    
    
    int count = getJdbcTemplate().queryForInt(sqlStr.toString());
    
    return count;
  } // end getPersonCount
  

  
  
  
  
  
  
  /**
   *  �Ǧ^�Ҧ���Person 
   */
  @SuppressWarnings("all")
  public List<Person> listPersons() {
    System.out.println(PersonDAOImpl.class.getName() + ", listPersons Method execute ...");
   
    List <Person> personList = new ArrayList<Person>();
    
    
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  select id,name,sex,age,birthday    \n");
    sqlStr.append("    from tb_person                   \n");
    System.out.println(PersonDAOImpl.class.getName() + " , listPersons SQL �y�k \n" + sqlStr.toString());
    
    
    Person person = null;
    List<Map<String,Object>> list = getJdbcTemplate().queryForList(sqlStr.toString());
    for(Map<String,Object> row:list){
      person = new Person();
      person.setId((Integer)row.get("id"));
      person.setName((String)row.get("name"));
      person.setSex((String)row.get("sex"));
      person.setBirthday((Date)row.get("birthday"));
      
      personList.add(person);
    } // end for(Map<String,Object> row:list){
    
    return personList;
  } // end listPersons
  

  
  
  
  
  
  
  // �Ǧ^�Ҧ���Person(�ĥ�MappingSqlQuery ��)
  public List<Person> findAllPerson(){
    
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  select id,name,sex,age,birthday    \n");
    sqlStr.append("    from tb_person                   \n");
    System.out.println(PersonDAOImpl.class.getName() + " , findAllPerson SQL �y�k \n" + sqlStr.toString());
    
    
    /*
     *  MappingSqlQuery �O�@�ө�H���O�A�}�o�̻ݭn�ꥦ�� mapRow(ResultSet,int) ��k��{�q ResultSet �� Java ���󪺬M�g�C
     *  �Ӥ�k�����Ǧ^�������O����C  
     */
    PersonMappingQuery personQuery = new PersonMappingQuery();
    personQuery.setDataSource(getDataSource());
    personQuery.setSql(sqlStr.toString());
    personQuery.compile();
    
    List<Person> listPerson = personQuery.execute(new Object[]{});
    
    
    return listPerson;   // �����ʸ˫᪺List   
  } // end findAllPerson()
  
  
  
  
  
  
  
  /**
   *  ��s tb_person �ʧO (�ϥ� SqlUpdate)
   */
  public int sqlUpdate(Integer id,String sex){
    
    UpdateCreditRating ucr = new UpdateCreditRating(getDataSource());
    
    return ucr.run(id, sex);
  } // end sqlUpdate
  
  
  
  
  
  
  /**
   *  ���� SpringFramework SqlFunction 
   */
  public int countRows(){
   
    /*
     *  SqlFunction �Ǧ^��@�檺�d�ߵ��G�A�w�]�Ǧ^ int �����C
     *  �}�o�̥i�H�����^��L��������ơB�\��۷�� JdbcTemplate �� queryForInt()�BqueryForString()�BqueryForObject() ���C 
     */
    SqlFunction sf = new SqlFunction(getDataSource(),"select count(*) from tb_person  ");
    sf.compile();
   
    
    return sf.run(); 
  } // end countRows()
  
  
  
  
  
}
