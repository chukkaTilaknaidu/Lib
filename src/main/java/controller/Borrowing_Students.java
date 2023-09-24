/*package controller;

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

@WebServlet("/Borrowing_Students")
public class Borrowing_Students extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IBookService bookService = BookServiceFactory.getBookService();
        Dto searchResult = bookService.request_return();
        PrintWriter out = response.getWriter();
        
        if (searchResult != null) {
            int regNumber = searchResult.getReturn_Request_RegisterNumber();
            long book_ISBN = searchResult.getReturn_Request_BookISBN();
            searchResult.setDelete_isbn(book_ISBN);
            searchResult.setDelete_registerNumber(regNumber);

            // Check if the request should be denied based on your business logic
            boolean shouldDenyRequest = false; // Implement your logic here

            if (shouldDenyRequest) {
                // Print "Request Denied" message
                out.println("Request Denied");
            } else {
                // Call the service method to process the request in Borrowing_Students
                Dto d = new Dto();
                d.setBorrowing_Register_Number(regNumber);
                d.setBorrowing_ISBN(book_ISBN);
                String status = bookService.student_Borrowings();

                if (status.equals("success")) {
                    out.println("<h1>BOOK ADDED TO STUDENT ACCOUNTS</h1>");
                } else {
                    out.println("<h1>BOOK NOT ADDED</h1>");
                }
            }
        }
    }
}*/