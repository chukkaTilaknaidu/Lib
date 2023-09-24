package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookServiceFactory.BookServiceFactory;
import dto.Dto;
import service.IBookService;

@WebServlet("/LibrarianLogin")
public class LibrarianLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IBookService librarianService = BookServiceFactory.getBookService();
		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());

		String id = request.getParameter("registrationNumber");
		String password = request.getParameter("password");
		Dto searchResult = librarianService.librarian_Login(Integer.parseInt(password));

		PrintWriter out = response.getWriter();
		if (searchResult != null) {

			if (searchResult.getLibrarian_register_login() == Integer.parseInt(id)
					&& searchResult.getLibrarian_password_login() == Integer.parseInt(password)) {
				RequestDispatcher rd = request.getRequestDispatcher("/bookManagement.html");
				rd.forward(request, response);
			} else {
				out.println(
						"  <h1><CENTER>INVALID CREDENTIALS GO AND REGISTER FIRST IF YOU'RE NEW LIBRARIAN</CENTER>  </h1><BR><BR> <h2><center> <a href=index.html class=\"btn\"> CLICK HERE TO REGISTER PAGE </a></center></h2>");
			}

		} else {
			out.println(
					"  <h1><CENTER>INVALID CREDENTIALS GO AND REGISTER FIRST IF YOU'RE NEW LIBRARIAN</CENTER>  </h1><BR><BR> <h2><center> <a href=index.html class=\"btn\"> CLICK HERE TO REGISTER PAGE </a></center></h2>");
		}

	}

}
