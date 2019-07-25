package semi.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.dao.DaoDatabase1;
import semi.dto.DtoDatabase1;


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
		
		if(command.equals("login")) {
			String myid = request.getParameter("id");
			String mypw = request.getParameter("pw");
			
			DtoDatabase1 dto = biz.login(myid, mypw);
			
			if(dto.getMyid() != null){
				//session : JSP의 스코프중 하나, 클라이언트가 서버에 접속했을때 가지는 브라우저
				//새로운 페이지로 넘어가도 세션이 만료되기 전까지 객체? 를 가져올수 있다
				
				session.setAttribute("dto", dto);		
				//접속 시간 : seconds로 계산된다 , 10분동안 활동이 없으면 session의 dto가 사라진다.
				session.setMaxInactiveInterval(10*60);

				if(dto.getMyrole().equals("ADMIN")){
					response.sendRedirect("adminmain.jsp");
				}else if(dto.getMyrole().equals("USER")){
					response.sendRedirect("usermain.jsp");			
				}
			}else{
				%>
				<script type="text/javascript">
					alert("login 실패! id와 비번 확인ㅐ");
					location.href="index.jsp";
				</script>
				<%
			}
		} else if(command.equals("logout")) {
		} else if(command.equals("userinfo")) {
		} else if(command.equals("userupdate")) {
		} else if(command.equals("deleteuser")) {
		} else if(command.equals("registform")){
		} else if(command.equals("idchk")) {
		} else if(command.equals("alluser")){
		} else if(command.equals("enableduser")){
		} else if(command.equals("createuser")){
		} else if(command.equals("page")){
		} else if(command.equals("updateroleform")){
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
