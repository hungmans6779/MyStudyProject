package com.framework.spring.dao.jdbcMappingDao;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import com.framework.spring.dao.impl.PersonDAOImpl;


/*
 *  SqlUpdate �ΨӰ���SQL ��s�ԭz�A�i�H�]�w�ѼơC�i��P JdbcDaoSupport �O�@�˪��C
 *  SqlUpdate �i�H�N�Y�ӥ\��ҲդơC
 */
public class UpdateCreditRating extends SqlUpdate {

  // �غc���
  public UpdateCreditRating(DataSource ds){
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append(" update tb_person             \n");
    sqlStr.append("    set sex = ?               \n");
    sqlStr.append("  where id = ?                \n");
    System.out.println(UpdateCreditRating.class.getName() + " , sqlUpdate SQL �y�k \n" + sqlStr.toString());

    
    // �]�w��Ʈw
    setDataSource(ds);
    setSql(sqlStr.toString());
    
    
    declareParameter(new SqlParameter(Types.VARBINARY));   // �]�w�ѼƦ�m
    declareParameter(new SqlParameter(Types.INTEGER));     // �]�w�ѼƦ�m
    

    compile();                                              // �sĶ SQL
  } // end UpdateCreditRating(DataSource ds)
  
  
  
  
  
  
  
  
  // ����
  public int run(Integer id,String rating){
    Object [] params = new Object[]{
                                     new String(rating),
                                     new Integer(id)};
    
    return update(params);
  } // end run
  
  
  
  
  
  
}
