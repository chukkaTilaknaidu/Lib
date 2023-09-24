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

@WebServlet("/Student_Login")
public class Student_Login extends HttpServlet {
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

		IBookService studentService = BookServiceFactory.getBookService();
		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());
		System.out.println("SERVLET 2 IS EXECUTEING");

		String registrationNumber = request.getParameter("registrationNumber");
		String password = request.getParameter("password");

		Dto searchResult = studentService.student_Login(Integer.parseInt(registrationNumber));
		System.out.println(searchResult);

		PrintWriter out = response.getWriter();

		if (searchResult != null) {
			System.out.println(searchResult.getStudent_password_login());
			System.out.println(password);
			System.out.println(searchResult.getStudent_register_number());
			System.out.println(Integer.parseInt(registrationNumber));
			if (searchResult.getStudent_password_login().equals(password)
					&& searchResult.getStudent_register_number() == Integer.parseInt(registrationNumber)) {

				RequestDispatcher rd = request.getRequestDispatcher("/student_DashBoard.html");
				rd.forward(request, response);

			} else {
				out.println(
						"<h1> <center> INVALID CREDENTIALS......CHECK ONCE.... OR ELSE GO AND REGISTER </center> </h1>");
				out.println("<a href=index.html> <center> TOUCH ME TO REGISTER </center> </a>");
			}
		}

	}

}
