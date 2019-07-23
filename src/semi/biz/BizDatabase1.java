package semi.biz;

import java.util.List;

import common.JDBCTemplate;
import semi.dao.DaoDatabase1;
import semi.dto.DtoDatabase1;

public class BizDatabase1 extends JDBCTemplate{
	static DaoDatabase1 dao;
	public BizDatabase1() {
		dao = new DaoDatabase1();
	}
	public DtoDatabase1 login(String myid, String mypw) {
		return dao.login(myid, mypw);
	}
	public String idChk(String myid) {
		return dao.idChk(myid);
	}
	public int update(DtoDatabase1 dto) {
		return dao.update(dto);
	}
	public int deleteUser(int myno) {
		return dao.deleteUser(myno);
	}
	public int insert(DtoDatabase1 dto) {
		return dao.insert(dto);
	}
	public List<DtoDatabase1> alluser(){
		return dao.alluser();
	}
	public List<DtoDatabase1> enableduser(){	
		return dao.enableduser();
	}
	public int createuser(){	
		return dao.createuser();
	}
	public int updaterole(int myno, String myrole) {
		return dao.updaterole(myno, myrole);
	}
}
