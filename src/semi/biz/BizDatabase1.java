package semi.biz;

import java.util.List;

import common.JDBCTemplate;
import semi.dto.DtoDatabase1;

public class BizDatabase1 extends JDBCTemplate{
	
	public List<DtoDatabase1> getCalList(String id, String yyyyMMdd){
		return null;
	}
	public int insertCalBoard(DtoDatabase1 dto) {
		return 0;
	}
	public int deleteCalBoard(int seq) {
		return 0;
	}
	public List<DtoDatabase1> getCalViewList(String id, String yyyyMM){
		return null;
	}
	public int getCalViewCount(String id, String yyyyMMdd) {
		return 0;
	}
}
