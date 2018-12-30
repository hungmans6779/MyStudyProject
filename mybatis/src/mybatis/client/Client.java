package mybatis.client;

import static org.apache.ibatis.io.Resources.getResourceAsReader;

import java.io.Reader;
import java.util.List;

import mybatis.dao.PetMapper;
import mybatis.model.Pet;
import mybatis.model.PetExample;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/*
 *  
 *  SqlSessionFactoryBuilder
 * 這個類可以被實例化,使用和丟棄。一旦你創建了SqlSessionFactory 後,這個類就不需要存在了。因此SqlSessionFactoryBuilder 實例的最佳範圍是方法範圍(也就是本地方法變量)。
  * 你可以重用SqlSessionFactoryBuilder 來創建多個SqlSessionFactory 實例,但是最好的方式是不需要保持它一直存在來保證所有XML 解析資源,因為還有更重要的事情要做。
 *  
 *  
 *  SqlSessionFactory
 * 一旦被創建,SqlSessionFactory 應該在你的應用執行期間都存在。沒有理由來處理或重新創建它。使用SqlSessionFactory 的最佳實踐是在應用運行期間不要重複創建多次。
  * 這樣的操作將被視為是非常糟糕的。因此SqlSessionFactory 的最佳範圍是應用範圍。有很多方法可以做到, 最簡單的就是使用單例模式或者靜態單例模式。
 *
 *
 *  SqlSession
 * 每個線程都應該有它自己的SqlSession 實例。 SqlSession 的實例不能被共享,也是線程不安全的。因此最佳的範圍是請求或方法範圍。
  * 絕對不能將SqlSession 實例的引用放在一個類的靜態字段甚至是實例字段中。也絕不能將SqlSession 實例的引用放在任何類型的管理範圍中,
  * 比如 Serlvet 架構中的 HttpSession。如果你現在正用任意的Web 框架, 要考慮SqlSession 放在一個和HTTP 請求對象相似的範圍內。
  * 換句話說,基於收到的HTTP 請求,你可以打開了一個SqlSession,然後返迴響應,就可以關閉它了。關閉Session 很重要,你應該確保使用finally 塊來關閉它。
 *
 *
 *
 */
public class Client {

	
	public static void main(String[] args) throws Exception  {

		String resource = "mybatis/client/MapperConfig_Pet.xml";

		Reader reader = Resources.getResourceAsReader(resource);  

		
		/*
		 * 為了明確創建哪種環境,你可以將它作為可選的參數傳遞給SqlSessionFactoryBuilder。可以接受環境配置的兩個方法簽名是:
		 * SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader,
		 * environment); SqlSessionFactory factory =
		 * sqlSessionFactoryBuilder.build(reader, environment,properties);
		 * 
		 * 如果環境被忽略,那麼默認環境將會被加載,如下進行: SqlSessionFactory factory =
		 * sqlSessionFactoryBuilder.build(reader); SqlSessionFactory factory =
		 * sqlSessionFactoryBuilder.build(reader,properties);
		 */
		
		// SqlSessionFactory sqlMapper = new
		// SqlSessionFactoryBuilder().build(reader);
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader, "development01");
		SqlSession sqlSession = sqlMapper.openSession();

		try {
			PetMapper mapper = sqlSession.getMapper(PetMapper.class);

			PetExample pet = new PetExample();
			pet.or().andDeathIsNotNull();

			List<Pet> allRecords = mapper.selectByExample(pet);
			System.out.println("allRecords size = " + allRecords.size());
			for (Pet p : allRecords) {
				System.out.println("name    = " + p.getName());
				System.out.println("owen    = " + p.getOwner());
				System.out.println("species = " + p.getSpecies());
				System.out.println("sex     = " + p.getSex());
				System.out.println("birth   = " + p.getBirth());
				System.out.println("death   = " + p.getDeath());

				System.out.println("\n");
			} // end for (Pet p : allRecords){
		} finally {
			sqlSession.close();
		}
		
	} // end main
	

}
