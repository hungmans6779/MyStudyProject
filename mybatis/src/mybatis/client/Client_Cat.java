package mybatis.client;

import java.io.Reader;
import java.util.List;

import mybatis.dao.CatMapper;
import mybatis.model.PetExample;
import mybatis.pojo.Cat;
import mybatis.pojo.CatExample;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Client_Cat {

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception  {

    String resource = "mybatis/client/MapperConfig_Cat.xml";

    Reader reader = Resources.getResourceAsReader(resource);  

    SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader, "development01");
    SqlSession sqlSession = sqlMapper.openSession();

    CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
    
    Cat cat = catMapper.selectByPrimaryKey(2);
    if(cat!=null){
      System.out.println("id         = " + cat.getId());
      System.out.println("name       = " + cat.getName());
      System.out.println("createDate = " + cat.getCreatedate());   
    }
    
  } // end main
  
  

}
