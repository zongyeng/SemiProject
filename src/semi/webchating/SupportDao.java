package webchating;
import org.apache.ibatis.session.SqlSession;

public class SupportDao {
	
	private String namespace = "webchartingmapper.";
	sqlMapConfig getSqlSessionFactory = new sqlMapConfig();
	
	public UserinfoDto selectOne(int seq) {
		SqlSession session = null;
		UserinfoDto dto = new UserinfoDto();
		try {
			session = getSqlSessionFactory.getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace+"selectOne",seq);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}
}
