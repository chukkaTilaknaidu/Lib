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

@WebServlet("/FineCalculation")
public class FineCalculation extends HttpServlet {
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
		Dto d = new Dto();
		d.setFine_Register_Number(Integer.parseInt(regNumber));
		Dto resultSearch = studentService.fineCalculation(d);

		if (resultSearch != null) {
			long days = resultSearch.getDate();
			int fine = 15;
			long fine_calculate = days * fine;
			out.println("<h1>THIS IS YOUR FINE: " + fine_calculate + " </h1><BR><BR>");

			out.println("<h1> PAY AND RETURN THE BOOK</h1><BR><BR>");
			out.println("<h1>DON'T FEEL HESITATE TO USE ME AGAIN........KEEP SMILE</h1>");
			out.println("<h1><a href=student_DashBoard.html><center>GO BACK</center></a></h1>");

		} else {
			out.println("<h1>Unable to calculate fine. Result is null.</h1>");
		}
	}
}