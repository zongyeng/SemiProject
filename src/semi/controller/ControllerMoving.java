package semi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.dao.Util;
import semi.dao.DaoDatabase1;
import semi.dto.DtoDatabase1;
import semi.dto.calDto;


@WebServlet("/cal.do")
public class ControllerMoving extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoDatabase1 dao = new DaoDatabase1();

    public ControllerMoving() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		
		if(command.equals("calendar")) {
			response.sendRedirect("calendar.jsp");
		} else if(command.equals("calendar2")) {
			response.sendRedirect("CalendarExam.jsp");
		} else if(command.equals("insertcal")) {
			int res = 0;
			String id = request.getParameter("id");
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");
			String hour = request.getParameter("hour");
			String min = request.getParameter("min");
			
			String mdate = year+Util.isTwo(month)+Util.isTwo(date)+Util.isTwo(hour)+Util.isTwo(min);
					
			DtoDatabase1 dto = new DtoDatabase1();
			dto.setId(id);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setMdate(mdate);
					
			res = dao.insertCalBoard(dto);
			
			if(res > 0) {
				alert(response, "일정 추가 성공!", "cal.do?command=calendar");
			} else {
				dispatch("error.jsp", request,response);
			}
		} else if(command.equals("delete")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			
		} else if(command.equals("callist")) {
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");
			
			String yyyyMMdd = year + Util.isTwo(month)+Util.isTwo(date);
			
			List<DtoDatabase1> list = dao.getCalList("kh", yyyyMMdd);
			request.setAttribute("list", list);
			dispatch("callist.jsp", request, response);
			
		} else if(command.equals("calviewlist")){
			
		} else if(command.equals("selectone")) {
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	
	public void alert(HttpServletResponse response, String message, String url) throws IOException {	
		
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">"
				+ " alert ('" + message + "');"
				+ " location.href='"+url+"';"
				+ "</script>");

		}

}
