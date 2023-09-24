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

@WebServlet("/run/*")
public class Library extends HttpServlet {
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

		if (request.getRequestURI().endsWith("addBook")) {
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/add");

			rd.forward(request, response);

		}

		if (request.getRequestURI().endsWith("deleteBook")) {
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/delete");

			rd.forward(request, response);

		}
		if (request.getRequestURI().endsWith("searchBook")) {

			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/search");

			rd.forward(request, response);

		}
		if (request.getRequestURI().endsWith("studentRegistration--")) {
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/addStudent");
			rd.forward(request, response);

		}
		if (request.getRequestURI().endsWith("librarianRegistration")) {
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/AddLibrarian");
			rd.forward(request, response);

		}
		if (request.getRequestURI().endsWith("studentLogin")) {
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("student_Login");
			rd.forward(request, response);
		}

		if (request.getRequestURI().endsWith("librarianLogin")) {
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/LibrarianLogin");

		}
		if (request.getRequestURI().endsWith("borrowBook")) {
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/Borrow_Book");
			rd.forward(request, response);
		}

		if (request.getRequestURI().endsWith("student_Request")) {
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/Student_Requests");
			rd.forward(request, response);
		}
		if (request.getRequestURI().endsWith("delete_Request")) {
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/Delete_Requests");
			rd.forward(request, response);
		}
		if (request.getRequestURI().endsWith("Borrowing_Students")) {
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/Borrowing_Students");
			rd.forward(request, response);
		}

	}

}
