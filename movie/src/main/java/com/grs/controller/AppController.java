package com.grs.controller;

import java.io.IOException;

import com.grs.dao.MovieDAO;
import com.grs.model.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/getmovie")
public class AppController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int mid = Integer.parseInt(request.getParameter("mid"));
		
		MovieDAO dao =new MovieDAO();
		Movie film = null;
		try {
			film = dao.getMovie(mid);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();
		HttpSession session = request.getSession();
		session.setAttribute("movie", film);
		response.sendRedirect("movie.jsp");
	}

}
