package com.framework.spring.dao.jdbcMappingDao;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import com.framework.spring.dao.impl.PersonDAOImpl;


/*
 *  SqlUpdate ノㄓ磅︽SQL 穝痹瓃砞﹚把计籔 JdbcDaoSupport 琌妓
 *  SqlUpdate 盢琘家舱て
 */
public class UpdateCreditRating extends SqlUpdate {

  // 篶ㄧ计
  public UpdateCreditRating(DataSource ds){
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append(" update tb_person             \n");
    sqlStr.append("    set sex = ?               \n");
    sqlStr.append("  where id = ?                \n");
    System.out.println(UpdateCreditRating.class.getName() + " , sqlUpdate SQL 粂猭 \n" + sqlStr.toString());

    
    // 砞﹚戈畐
    setDataSource(ds);
    setSql(sqlStr.toString());
    
    
    declareParameter(new SqlParameter(Types.VARBINARY));   // 砞﹚把计竚
    declareParameter(new SqlParameter(Types.INTEGER));     // 砞﹚把计竚
    

    compile();                                              // 絪亩 SQL
  } // end UpdateCreditRating(DataSource ds)
  
  
  
  
  
  
  
  
  // 磅︽
  public int run(Integer id,String rating){
    Object [] params = new Object[]{
                                     new String(rating),
                                     new Integer(id)};
    
    return update(params);
  } // end run
  
  
  
  
  
  
}
