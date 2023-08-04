package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/community/*")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String postId = pathParts[1];
        
        // postId로부터 데이터베이스에서 게시물 정보를 가져옵니다.
        Post post = getPostFromDatabase(postId);
        
        // request 객체에 게시물 정보를 속성으로 추가합니다.
        request.setAttribute("post", post);
        
        // JSP 페이지로 요청을 전달합니다.
        RequestDispatcher dispatcher = request.getRequestDispatcher("/post.jsp");
        dispatcher.forward(request, response);
	}

}
