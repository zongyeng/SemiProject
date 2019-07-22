package semi.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import semi.dto.calDto;

public class Util {
	
	private String toDates;
	
	public String getToDates() {
		return toDates;
	}
	public void setToDates(String mdate) {
		// mdate(yyyyMMddhhmm) -> yyyy-MM-dd hh:mm:00
		// -> yyyy년 MM월 dd일 hh시 mm분
		
		String m = mdate.substring(0, 4)+"-"+mdate.subSequence(4, 6)+"-"+mdate.substring(6, 8)
		+" "+mdate.substring(8, 10)+":"+mdate.substring(10)+":00";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 ");
		Timestamp tm = Timestamp.valueOf(m);
		toDates = sdf.format(tm);
	}
	
	// 만일 한 자리 숫자면 0 붙여서 2자리 숫자로 리턴하자 !
	public static String isTwo(String msg) {
		
		return (msg.length() < 2) ? "0" + msg: msg;
	}
	
	public static String fontColor(int date, int dayOfWeek) {
		
		String color = null;
		
		// 토요일 ( 1~7로 잡음, 7이 토요일, 1이 일요일)
		if((dayOfWeek+date-1)%7 == 0) {
			color = "blue";
		} else if((dayOfWeek+date-1)%7 == 1) {
			color = "red";
		} else {
			color = "black";
		}
		
		
		return color;
	}
	
	public static String getCalView(int i, List<calDto> clist) {
		
		String d = isTwo(i+"");	// isTwo의 int i을 String으로 형 변환!
		String res = "";
		
		for(calDto dto : clist) {
			if(dto.getMdate().substring(6, 8).equals(d)) {	// 넣어준 일 수와 같은 값이 dto에 들어 있는지 
				res += "<p>"+
						((dto.getTitle().length()>6)?dto.getTitle().substring(0, 5)+"...":dto.getTitle())
											// title이 6이 넘어가면 ...으로 보여주고 아니라면 그냥 보여주라
						+"</p>";
			}
		}
		
		return res;
	}

}





