package com.cal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cal.dao.calDao;

import net.sf.json.JSONObject;


@WebServlet("/CalCountAjax.do")
public class CalCountAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CalCountAjax() { super(); }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String yyyyMMdd = request.getParameter("yyyyMMdd");
		
		calDao dao = new calDao();
		int count = dao.getCalViewCount(id, yyyyMMdd);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("cnt", count);
		JSONObject obj = JSONObject.fromObject(map);
		
		PrintWriter out = response.getWriter();
		obj.write(out);
	}

}
