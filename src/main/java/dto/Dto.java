package dto;

import java.io.Serializable;

public class Dto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String author;
	private String category;
	private int ISBN;
	private int no_Of_Copies;
	private long student_Isbn;
	private long delete_isbn;

	private long date;

	private int fine_Register_Number;

	public int getFine_Register_Number() {
		return fine_Register_Number;
	}

	public void setFine_Register_Number(int fine_Register_Number) {
		this.fine_Register_Number = fine_Register_Number;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	private int return_registerNumber;

	public int getReturn_registerNumber() {
		return return_registerNumber;
	}

	public void setReturn_registerNumber(int return_registerNumber) {
		this.return_registerNumber = return_registerNumber;
	}

	public long getReturn_book_ISBN() {
		return return_book_ISBN;
	}

	public void setReturn_book_ISBN(long return_book_ISBN) {
		this.return_book_ISBN = return_book_ISBN;
	}

	private long return_book_ISBN;

	private int borrowing_Register_Number;

	public int getBorrowing_Register_Number() {
		return borrowing_Register_Number;
	}

	public void setBorrowing_Register_Number(int borrowing_Register_Number) {
		this.borrowing_Register_Number = borrowing_Register_Number;
	}

	public long getBorrowing_ISBN() {
		return borrowing_ISBN;
	}

	public void setBorrowing_ISBN(long borrowing_ISBN) {
		this.borrowing_ISBN = borrowing_ISBN;
	}

	private long borrowing_ISBN;

	public long getDelete_isbn() {
		return delete_isbn;
	}

	public void setDelete_isbn(long delete_isbn) {
		this.delete_isbn = delete_isbn;
	}

	public int getDelete_registerNumber() {
		return delete_registerNumber;
	}

	public void setDelete_registerNumber(int delete_registerNumber) {
		this.delete_registerNumber = delete_registerNumber;
	}

	private int delete_registerNumber;

	private int return_Request_RegisterNumber;

	public int getReturn_Request_RegisterNumber() {
		return return_Request_RegisterNumber;
	}

	public void setReturn_Request_RegisterNumber(int return_Request_RegisterNumber) {
		this.return_Request_RegisterNumber = return_Request_RegisterNumber;
	}

	public long getReturn_Request_BookISBN() {
		return return_Request_BookISBN;
	}

	public void setReturn_Request_BookISBN(long return_Request_BookISBN) {
		this.return_Request_BookISBN = return_Request_BookISBN;
	}

	private long return_Request_BookISBN;

	private int request_RegisterNumber;

	public int getRequest_RegisterNumber() {
		return request_RegisterNumber;
	}

	public void setRequest_RegisterNumber(int request_RegisterNumber) {
		this.request_RegisterNumber = request_RegisterNumber;
	}

	public long getRequest_Book_ISBN() {
		return request_Book_ISBN;
	}

	public void setRequest_Book_ISBN(long request_Book_ISBN) {
		this.request_Book_ISBN = request_Book_ISBN;
	}

	private long request_Book_ISBN;

	public long getStudent_Isbn() {
		return student_Isbn;
	}

	public void setStudent_Isbn(long student_Isbn) {
		this.student_Isbn = student_Isbn;
	}

	private int Librarian_password_login;

	public int getLibrarian_password_login() {
		return Librarian_password_login;
	}

	public void setLibrarian_password_login(int librarian_password_login) {
		Librarian_password_login = librarian_password_login;
	}

	public int getLibrarian_register_login() {
		return Librarian_register_login;
	}

	public void setLibrarian_register_login(int librarian_register_login) {
		Librarian_register_login = librarian_register_login;
	}

	private int Librarian_register_login;

	private String student_password_login;

	public String getStudent_password_login() {
		return student_password_login;
	}

	public void setStudent_password_login(String student_password_login) {
		this.student_password_login = student_password_login;
	}

	public int getStudent_register_number() {
		return student_register_number;
	}

	public void setStudent_register_number(int student_register_number) {
		this.student_register_number = student_register_number;
	}

	private int student_register_number;

	private String librarian_Name;

	public String getLibrarian_Name() {
		return librarian_Name;
	}

	public void setLibrarian_Name(String librarian_Name) {
		this.librarian_Name = librarian_Name;
	}

	public int getLibrarian_Register_Number() {
		return librarian_Register_Number;
	}

	public void setLibrarian_Register_Number(int librarian_Register_Number) {
		this.librarian_Register_Number = librarian_Register_Number;
	}

	public String getLibrararian_Emaill() {
		return Librararian_Emaill;
	}

	public void setLibrararian_Emaill(String librararian_Emaill) {
		Librararian_Emaill = librararian_Emaill;
	}

	public String getPassword_Librarian() {
		return password_Librarian;
	}

	public void setPassword_Librarian(String password_Librarian) {
		this.password_Librarian = password_Librarian;
	}

	public long getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(long phone_Number) {
		this.phone_Number = phone_Number;
	}

	private int librarian_Register_Number;
	private String Librararian_Emaill;
	private String password_Librarian;
	private long phone_Number;

	private String studentName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentRegistrationNumber() {
		return studentRegistrationNumber;
	}

	public void setStudentRegistrationNumber(int studentRegistrationNumber) {
		this.studentRegistrationNumber = studentRegistrationNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private int studentRegistrationNumber;
	private String email;
	private String password;
	private long phoneNumber;

	public void setNo_Of_Copies(int no_Of_Copies) {
		this.no_Of_Copies = no_Of_Copies;
	}

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public int getNo_Of_Copies() {
		return no_Of_Copies;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;

	}

	/*
	 * public String toString() { return "Student [sauthor=" + author + ",stitle=" +
	 * title + ",scategory= " + category + ",sisbn=" + ISBN + ",sno_of_copies=" +
	 * no_Of_Copies + "]"; }
	 */
}
