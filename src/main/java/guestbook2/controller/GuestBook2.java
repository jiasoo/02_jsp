package guestbook2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook2.model.Command;
import guestbook2.model.DeleteCommand;
import guestbook2.model.DeleteOkCommand;
import guestbook2.model.ListCommand;
import guestbook2.model.OneListCommand;
import guestbook2.model.UpdateCommand;
import guestbook2.model.UpdateOkCommand;


import guestbook2.model.WriteCommand;
import guestbook2.model.WriteOkCommand;


@WebServlet("/Guestbook2")
public class GuestBook2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String cmd = request.getParameter("cmd");
		Command comm = null;
		if(cmd.equals("list")) {
			
		}else if(cmd.equals("write")) {
			comm = new WriteCommand();		
		}else if(cmd.equals("write_ok")) {			
			comm = new WriteOkCommand();
		}else if(cmd.equals("onelist")) {
			comm = new OneListCommand();
		}else if(cmd.equals("update")){
			comm = new UpdateCommand();
		}else if(cmd.equals("delete")){
			comm = new DeleteCommand();
		}else if(cmd.equals("update_ok")) {
			comm = new UpdateOkCommand();
		}else if(cmd.equals("delete_ok")) {
			comm = new DeleteOkCommand();
		}
		String path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
		
		
				
		
	}

}
