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

@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {

		IBookService studentService = BookServiceFactory.getBookService();
		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());
		System.out.println("SERVLET 2 IS EXECUTEING");

		String librarianName = request.getParameter("librarianName");
		String librarianRegisterNumber = request.getParameter("librarianID");
		String email = request.getParameter("emailID");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phone");
		System.out.println(librarianName);
		System.out.println(librarianRegisterNumber);
		System.out.println(email);
		System.out.println(password);
		System.out.println(phoneNumber);
		int srn = Integer.parseInt(librarianRegisterNumber);
		long pn = Long.parseLong(phoneNumber);

		Dto dto = new Dto();

		dto.setLibrarian_Name(librarianName);
		dto.setLibrarian_Register_Number(srn);
		dto.setLibrararian_Emaill(email);

		dto.setPassword_Librarian(password);
		dto.setPhone_Number(pn);

		String status = studentService.addLibrarian(dto);
		PrintWriter out = response.getWriter();
		if (status.equals("sucess")) {
			out.println("<h1>Student ADDED SUCESSFULL</h1>");

		} else {
			out.println("<h1>STUDENT NOT ADDED </h1>");
		}

	}
}
