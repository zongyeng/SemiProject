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
		} else if(command.equals("logout")) {
		} else if(command.equals("userinfo")) {
		} else if(command.equals("userupdate")) {
		} else if(command.equals("deleteuser")) {
		} else if(command.equals("registform")){
		} else if(command.equals("idchk")) {
		} else if(command.equals("alluser")){
		} else if(command.equals("enableduser")){
		}else if(command.equals("createuser")){
		}else if(command.equals("page")){
		}else if(command.equals("updateroleform")){
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
