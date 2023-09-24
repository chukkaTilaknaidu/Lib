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

@WebServlet("/delete")
public class DeleteBook extends HttpServlet {
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

		IBookService bookService = BookServiceFactory.getBookService();
		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());
		String isbn = request.getParameter("isbn");
		Dto dto = new Dto();
		dto.setISBN(Integer.parseInt(isbn));
		String status = bookService.deleteBook(dto);
		PrintWriter out = response.getWriter();
		System.out.println(status);
		if (status.equals("sucess")) {
			out.println("<h1 style='color:green; text-align:center;'> BOOK DELETED SUCESSFULLY</h1>");

		} else {
			out.println("<h1 style='color:green; text-align:center;'> BOOK  NOT DELETED SUCESSFULLY</h1>");

		}
	}

}
