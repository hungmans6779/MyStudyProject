package com.client;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.CatMapper;
import com.pojo.Cat;

public class ClientTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception {
    
    String resource = "com/client/SqlMapConfig.xml";

    Reader reader = Resources.getResourceAsReader(resource);  

    SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader, "development01");
    SqlSession sqlSession = sqlMapper.openSession();
   
    CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
   
    Cat cat = catMapper.findCatByName("kevin3");
    if(cat!=null){
      System.out.println("id         = " + cat.getId());
      System.out.println("name       = " + cat.getName());
      System.out.println("createDate = " + cat.getCreateDate());   
    }
    
  } // end main

  
  
}
