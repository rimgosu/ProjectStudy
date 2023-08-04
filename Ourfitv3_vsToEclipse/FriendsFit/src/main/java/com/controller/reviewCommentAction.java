package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.commentDTO;
import com.model.dbDAO;

/**
 * Servlet implementation class reviewCommentAction
 */
@WebServlet("/reviewCommentAction")
public class reviewCommentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String commentContent = request.getParameter("reviewComment");
		String reviewNum = request.getParameter("reviewNum");
		System.out.println(reviewNum);
		
		commentDTO commentdto = new commentDTO(0, commentContent, "TEST1", 1, "REGISTER_DATE", 0);
		
		dbDAO dbdao = new dbDAO();
		dbdao.commentUpload(commentdto);
		
		response.sendRedirect("reviewSee.jsp?reviewNum="+reviewNum);
		
		
		
	}

}
