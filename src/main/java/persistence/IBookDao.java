package persistence;

import dto.Dto;

public interface IBookDao {
	public abstract String addBook( Dto book);
	public abstract String deleteBook(Dto book);
	
	public abstract Dto searchBook(String title);
	public abstract  String addStudent(Dto book);
	public abstract String addLibrarian(Dto book);
	public abstract Dto student_Login(int RegisterNumber);
	public abstract Dto librarian_Login(int password);
	public abstract Dto bookBorrow(long isbn);
	public abstract String request(Dto requests);
	public abstract Dto request_return();
	
	public abstract String delete_Request(Dto dto);
	
	public abstract String return_Book(Dto dto);
	
	public abstract Dto fineCalculation(Dto dto);
	
	public abstract String status();
	

}
