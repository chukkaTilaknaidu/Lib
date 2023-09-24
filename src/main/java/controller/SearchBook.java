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

@WebServlet("/search")
public class SearchBook extends HttpServlet {
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

		String title = request.getParameter("title");

		/*
		 * Dto dto = new Dto(); dto.setTitle(title);
		 */

		// Call the searchBook method
		Dto searchResult = bookService.searchBook(title);

		PrintWriter out = response.getWriter();
		System.out.println(title);
		System.out.println(searchResult);

		if (searchResult != null) {
			out.println("<body>");
			out.println("<br/><br/><br/>");
			out.println("<center>");
			out.println("<table border='1'>");
			out.println("<tr><th>TITLE</th><td>" + searchResult.getTitle() + "</td></tr>");
			out.println("<tr><th>AUTHOR</th><td>" + searchResult.getAuthor() + "</td></tr>");
			out.println("<tr><th>CATEGORY</th><td>" + searchResult.getCategory() + "</td></tr>");

			out.println("<tr><th>ISBN</th><td>" + searchResult.getISBN() + "</td></tr>");
			out.println("<tr><th>AVAILABLE_COPIES</th><td>" + searchResult.getNo_Of_Copies() + "</td></tr><br><br>");

			out.println("</table>");

			out.println("</center>");
			out.println("<a href=\"student_DashBoard.html\"><center>go back</center></a>");
			out.println("</body>");
		}

		else {
			out.println("<h1>No results found for the given title.</h1>");
		}
	}

}
