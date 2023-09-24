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

@WebServlet("/Delete_Requests")
public class Delete_Requests extends HttpServlet {
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
		PrintWriter out = response.getWriter();

		if (searchResult != null) {
			int regNumber = searchResult.getReturn_Request_RegisterNumber();
			long book_ISBN = searchResult.getReturn_Request_BookISBN();
			Dto dto = new Dto();
			dto.setDelete_isbn(book_ISBN);
			dto.setDelete_registerNumber(regNumber);

			// Check if the request should be denied based on your business logic
			boolean shouldDenyRequest = false; // Implement your logic here

			if (shouldDenyRequest) {
				// Print "Request Denied" message
				out.println("Request Denied");
			} else {
				// Call the service method to delete the request
				String status = studentService.delete_Request(dto);

				if (status.equals("success")) {
					// Redirect to the confirmation page
					response.sendRedirect("confirmation.jsp");
				} else {
					// Handle the error case or show an error message
					// You can set an error attribute or display a message as needed
					// For example, request.setAttribute("errorMessage", "Failed to process the
					// request.");
					// Then you can forward to an error page or display the error on this page.
				}
			}
		}
	}
}
