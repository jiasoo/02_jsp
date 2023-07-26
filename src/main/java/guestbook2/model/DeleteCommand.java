package guestbook2.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook2.db.DAO;
import guestbook2.db.VO;

public class DeleteCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		
		VO vo = DAO.getOneList(idx);
		request.setAttribute("vo", vo);
		
		return "06_guestbook/delete.jsp";
	}
}