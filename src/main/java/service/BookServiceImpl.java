package service;

import daoFactory.BookDaoFactory;
import dto.Dto;
import persistence.IBookDao;

public class BookServiceImpl implements IBookService {
	private IBookDao ibd = null;

	@Override
	public String addBook(Dto book) {
		ibd = BookDaoFactory.getBookDao();
		if (ibd != null) {
			return ibd.addBook(book);
		}

		else {
			return null;
		}
	}

	@Override
	public String deleteBook(Dto book) {
		ibd = BookDaoFactory.getBookDao();
		if (ibd != null) {
			return ibd.deleteBook(book);
		} else {

			return null;
		}
	}

	@Override
	// public abstract List<Dto> searchBook(String title);
	public Dto searchBook(String title) {
		ibd = BookDaoFactory.getBookDao();
		if (ibd != null) {
			return ibd.searchBook(title);
		} else {

			return null;
		}
	}

	@Override
	public String addStudent(Dto book) {

		ibd = BookDaoFactory.getBookDao();
		if (ibd != null) {
			return ibd.addStudent(book);
		} else {

			return null;
		}

	}

	@Override
	public String addLibrarian(Dto book) {

		ibd = BookDaoFactory.getBookDao();
		if (ibd != null) {
			return ibd.addLibrarian(book);
		} else {

			return null;
		}

	}

	@Override
	public Dto student_Login(int RegisterNumber) {
		ibd = BookDaoFactory.getBookDao();
		if (ibd != null) {
			return ibd.student_Login(RegisterNumber);
		} 
		else {

			return null;
		}

}

	@Override
	public Dto librarian_Login(int password) {
		ibd = BookDaoFactory.getBookDao();
		if (ibd != null) {
			return ibd.librarian_Login(password);
		} 
		else {
		
		return null;
	}
}

	@Override
	public Dto borrowBook(long isbn) {
		ibd=BookDaoFactory.getBookDao();
		if(ibd !=null) {
			return ibd.bookBorrow(isbn);
		}
		else {
		return null;
		}
	}

	@Override
	public String request(Dto requests) {
	    ibd=BookDaoFactory.getBookDao();
	    if(ibd!=null) {
	    	return ibd.request(requests);
	    }
	    else {
		return null;
	    }
	}

	@Override
	public Dto request_return() {
		ibd=BookDaoFactory.getBookDao();
		if(ibd!=null) {
			return ibd.request_return();
		}
		else {
		return null;
		}
	}

	@Override
	public String delete_Request(Dto dto) {
	     
		ibd=BookDaoFactory.getBookDao();
		if(ibd!=null) {
			return ibd.delete_Request(dto);
		}
		else {
		return null;
		}
	}

	@Override
	public String return_Book(Dto dto) {
		ibd=BookDaoFactory.getBookDao();
		if(ibd !=null) {
		 return ibd.return_Book(dto);
		}
		else {
		return null;
		}
	}

	@Override
	public Dto fineCalculation(Dto dto) {
		ibd=BookDaoFactory.getBookDao();
		if(ibd!=null) {
			return ibd.fineCalculation(dto);
		}
		return null;
	}

	@Override
	public String status() {
		ibd=BookDaoFactory.getBookDao();
		if(ibd !=null) {
			return ibd.status();
		}
		else {
		return null;
		}
	}

	
	
}
