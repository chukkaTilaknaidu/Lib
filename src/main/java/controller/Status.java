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

@WebServlet("/Status")
public class Status extends HttpServlet {
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
		String status = studentService.status();
		PrintWriter out = response.getWriter();
		if (status != null) {
			if (status.equals("sucess")) {
				out.println("<h1> <CENTER> REQUEST ACCEPTED</CENTER></h1>");

			}
		} else {
			out.println(
					"<h1><center>REQUEST DENIED........OR .... YOU NOT SENT REQUEST  ........  OR ....................... LIBRARIAN STILL NOT ACCEPTED YOUR REQUEST</center></h1>");
		}

	}

}
