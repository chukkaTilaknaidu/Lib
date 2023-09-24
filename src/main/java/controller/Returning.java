package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookServiceFactory.BookServiceFactory;
import dto.Dto;
import jakarta.servlet.RequestDispatcher;
import service.IBookService;

@WebServlet("/Returning")
public class Returning extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		String regNumber = request.getParameter("register_Number");
		String book_ISBN = request.getParameter("book_ISBN");

		Dto d = new Dto();
		d.setReturn_registerNumber(Integer.parseInt(regNumber));
		d.setReturn_book_ISBN(Long.parseLong(book_ISBN));
		String status = studentService.return_Book(d);

		if (status != null) {
			if (status.equals("sucess")) {
				javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("fineCalculation.html");
				rd.forward(request, response);
			}
		} else {
			out.println("<h1>BOOK RETURNED FAILED or THIS IS NOT THE BOOK YOU BORROWED </h1>");
			out.println("<h1><a href=student_DashBoard.html><center>go back</center></a></h1>");
		}

	}

}
