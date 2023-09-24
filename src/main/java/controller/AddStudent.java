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

@WebServlet("/addStudent")
public class AddStudent extends HttpServlet {
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
			throws IOException, ServletException {

		IBookService studentService = BookServiceFactory.getBookService();
		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());
		System.out.println("SERVLET 2 IS EXECUTEING");

		String studentName = request.getParameter("studentName");
		System.out.println(studentName);

		String studentRegisterNumber = request.getParameter("studentRegisterNumber");
		String email = request.getParameter("email");
		String password = request.getParameter("setPassword");
		String phoneNumber = request.getParameter("phoneNumber");

		int srn = Integer.parseInt(studentRegisterNumber);
		long pn = Long.parseLong(phoneNumber);

		Dto dto = new Dto();
		dto.setStudentName(studentName);
		dto.setStudentRegistrationNumber(srn);
		dto.setEmail(email);
		dto.setPhoneNumber(pn);
		dto.setPassword(password);

		String status = studentService.addStudent(dto);
		PrintWriter out = response.getWriter();
		if (status.equals("sucess")) {
			RequestDispatcher rd = request.getRequestDispatcher("/sucessfull_Registration_student.html");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/failed_Registration_Student.html");
			rd.forward(request, response);

		}

	}

}
