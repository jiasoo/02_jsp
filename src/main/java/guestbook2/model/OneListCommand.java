package guestbook2.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.db.DAO;
import guestbook.db.VO;

public class OneListCommand implements Command{
	@Override
		public String exec(HttpServletRequest request, HttpServletResponse response) {
			// 일처리 = (DB)
			String idx = request.getParameter("idx");
			VO vo = DAO.getOneList(idx);
		
			// 저장 
		     request.setAttribute("vo", vo);
		
			return "06_guestbook/onelist.jsp";
		}	
}