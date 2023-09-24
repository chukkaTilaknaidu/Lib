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
import service.IBookService;

@WebServlet("/Student_Requests")
public class Student_Requests extends HttpServlet {
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
		Dto searchResult = studentService.request_return();

		// Retrieve the data from the searchResult object

		PrintWriter out = response.getWriter();

		// Set the attributes as strings
		if (searchResult != null) {
			int regNumber = searchResult.getReturn_Request_RegisterNumber();
			long book_ISBN = searchResult.getReturn_Request_BookISBN();

			String regNumberString = String.valueOf(regNumber);
			String bookISBNString = String.valueOf(book_ISBN);
			request.setAttribute("registrationNumber", regNumberString);
			request.setAttribute("bookISBN", bookISBNString);

			// Forward to the JSP page
			request.getRequestDispatcher("/librarianView.jsp").forward(request, response);
		}

		if (searchResult == null) {
			out.println("<h1><center> THERE IS NO REQUESTS......COOL</center></h1>");
			out.println("<h1><center><a href=bookManagement.html >GO BACK </a></center></h1>");

		}
	}
}
