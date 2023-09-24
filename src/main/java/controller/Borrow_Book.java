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

@WebServlet("/Borrow_Book")
public class Borrow_Book extends HttpServlet {
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
		System.out.println("SERVLET 2 IS EXECUTING");

		String regNumber = request.getParameter("registrationNumber");
		String bookIsbn = request.getParameter("bookISBN");
		int rn = Integer.parseInt(regNumber);

		long isbn = Long.parseLong(bookIsbn);
		request.setAttribute("registrationNumber", regNumber);
		request.setAttribute("bookISBN", bookIsbn);

		PrintWriter out = response.getWriter();
		Dto searchResult = studentService.borrowBook(isbn);
		Dto dto = new Dto();

		if (searchResult != null) {
			if (searchResult.getStudent_Isbn() == isbn) {

				// request.getRequestDispatcher("/Student_Requests").forward(request, response);
				dto.setRequest_RegisterNumber(rn);
				dto.setRequest_Book_ISBN(isbn);
				String status = studentService.request(dto);
				if (status.equals("sucess")) {
					out.println("<h1>REQUEST SENT TO LIBRARIAN</h1>");

				} else {
					out.println(
							"<h1><CENTER> SUBMIT THE BOROWED BOOKS FIRST  OR YOU'RE ALREADY REQUESTED</CENTER></h1>");
				}

			}
		} else {
			out.println("<h1>BOOK IS OUT OF STOCK</h1>");
		}

	}
}
