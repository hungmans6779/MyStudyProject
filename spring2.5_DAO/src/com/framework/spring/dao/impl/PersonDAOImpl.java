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
 *  實作 Person 的 DAO 介面
 *  
 *  繼承 Spring 的 DAO 模組中的  JdbcDaoSupport 類別。  JdbcDaoSupport 提供了 JdbcTemplate 物件，封裝了常用的 JDBC 操作。
 *  PersonDaoImpl 中還定義了一個初始化方法，用於初始化表結構(如果不存在則建立)。
 *  
 *  由於程式碼直接繼承了 Spring 提供的 JdbcDaoSupport，因此沒有使用 Connection、 Statement 等 JDBC API，也不用關閉這些資源。
 *  JdbcDaoSupport 會自動維護這些資源。
 *  程式碼中用 Spring 封裝好的 JdbcTemplate 來執行 SQL、查詢 Person 清單、查詢單一 Person 屬性值、查詢 Person 的總數。
 *  查詢 Person 列表時傳回的是一個 List<Map<String,Object>> 類型資料。  
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
    System.out.println(PersonDAOImpl.class.getName() + " , initDataBase SQL 語法 \n" + sqlStr.toString());
    
    
    
    getJdbcTemplate().execute(sqlStr.toString());
  } // end initDataBase()
  

  
  
  
  
  
  
  /**
   *  根據 id 獲得Person 姓名   
   */
  public String getPersonName(Integer id) {
    System.out.println(PersonDAOImpl.class.getName() + ", getPersonName Method execute ...");
    
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  select name        \n");
    sqlStr.append("    from tb_person   \n");
    sqlStr.append("   where id = ?      \n");
    System.out.println(PersonDAOImpl.class.getName() + " , getPersonName SQL 語法 \n" + sqlStr.toString());
    
    
    String name = (String)getJdbcTemplate().queryForObject(sqlStr.toString(), new Object[]{id}, String.class);
    
    return name;
  } // end getPersonName
  

  
  
  
  
  
  
  /**
   *  增加 Person 物件
   */
  public void addPerson(Person person) {
    System.out.println(PersonDAOImpl.class.getName() + ", addPerson Method execute ...");
    
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  insert into tb_person                 \n");
    sqlStr.append("         (name, sex,  age,  birthday)   \n");
    sqlStr.append("   values                               \n");
    sqlStr.append("         (?,    ?,    ?,    ?)          \n");
    System.out.println(PersonDAOImpl.class.getName() + " , addPerson SQL 語法 \n" + sqlStr.toString());
   
    
    getJdbcTemplate().update(sqlStr.toString(),new Object[]{
                                                            person.getName(),
                                                            person.getSex(),
                                                            person.getAge(),
                                                            person.getBirthday() 
                                                           });
    
  } // end addPerson
  

  
  
  
  
  
  
  /**
   *  傳回所有Person 的數目 
   */
  public int getPersonCount() {
    System.out.println(PersonDAOImpl.class.getName() + ", getPersonCount Method execute ...");
    
    StringBuffer sqlStr = new StringBuffer("select count(*) from tb_person ");
    System.out.println(PersonDAOImpl.class.getName() + " , getPersonCount SQL 語法 \n" + sqlStr.toString());
    
    
    int count = getJdbcTemplate().queryForInt(sqlStr.toString());
    
    return count;
  } // end getPersonCount
  

  
  
  
  
  
  
  /**
   *  傳回所有的Person 
   */
  @SuppressWarnings("all")
  public List<Person> listPersons() {
    System.out.println(PersonDAOImpl.class.getName() + ", listPersons Method execute ...");
   
    List <Person> personList = new ArrayList<Person>();
    
    
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  select id,name,sex,age,birthday    \n");
    sqlStr.append("    from tb_person                   \n");
    System.out.println(PersonDAOImpl.class.getName() + " , listPersons SQL 語法 \n" + sqlStr.toString());
    
    
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
  

  
  
  
  
  
  
  // 傳回所有的Person(採用MappingSqlQuery 的)
  public List<Person> findAllPerson(){
    
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  select id,name,sex,age,birthday    \n");
    sqlStr.append("    from tb_person                   \n");
    System.out.println(PersonDAOImpl.class.getName() + " , findAllPerson SQL 語法 \n" + sqlStr.toString());
    
    
    /*
     *  MappingSqlQuery 是一個抽象類別，開發者需要實它的 mapRow(ResultSet,int) 方法實現從 ResultSet 到 Java 物件的映射。
     *  該方法直接傳回實體類別物件。  
     */
    PersonMappingQuery personQuery = new PersonMappingQuery();
    personQuery.setDataSource(getDataSource());
    personQuery.setSql(sqlStr.toString());
    personQuery.compile();
    
    List<Person> listPerson = personQuery.execute(new Object[]{});
    
    
    return listPerson;   // 直接封裝後的List   
  } // end findAllPerson()
  
  
  
  
  
  
  
  /**
   *  更新 tb_person 性別 (使用 SqlUpdate)
   */
  public int sqlUpdate(Integer id,String sex){
    
    UpdateCreditRating ucr = new UpdateCreditRating(getDataSource());
    
    return ucr.run(id, sex);
  } // end sqlUpdate
  
  
  
  
  
  
  /**
   *  執行 SpringFramework SqlFunction 
   */
  public int countRows(){
   
    /*
     *  SqlFunction 傳回單一行的查詢結果，預設傳回 int 類型。
     *  開發者可以重載回其他類型的資料、功能相當於 JdbcTemplate 的 queryForInt()、queryForString()、queryForObject() 等。 
     */
    SqlFunction sf = new SqlFunction(getDataSource(),"select count(*) from tb_person  ");
    sf.compile();
   
    
    return sf.run(); 
  } // end countRows()
  
  
  
  
  
}
