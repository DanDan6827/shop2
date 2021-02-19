package com.ict.controller;

import java.io.IOException;




import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.Commend;
import com.ict.model.ListCommand;
import com.ict.model.addCartCommand;
import com.ict.model.contentCommand;
import com.ict.model.deleteCartCommand;
import com.ict.model.editCartCommand;
import com.ict.model.loginCommand;
import com.ict.model.login_okCommand;
import com.ict.model.logoutCommand;
import com.ict.model.productaddCommand;
import com.ict.model.viewCartCommand;




@WebServlet("/mycontroller")
public class mycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String cmd = request.getParameter("cmd");
		Commend comm = null;
		
		switch (cmd) {
		case "list":comm = new ListCommand(); break;
		case "logout":comm = new logoutCommand(); break;
		case "login":comm = new loginCommand(); break;
		case "login_ok":comm = new login_okCommand(); break;
		case "content":comm = new contentCommand(); break;
		case "addCart":comm = new addCartCommand(); break;
		case "viewCart":comm = new viewCartCommand(); break;
		case "edit":comm = new editCartCommand(); break;
		case "delete":comm = new deleteCartCommand(); break;
		case "product_add":comm = new productaddCommand(); break;
		
		
		}
		String path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
