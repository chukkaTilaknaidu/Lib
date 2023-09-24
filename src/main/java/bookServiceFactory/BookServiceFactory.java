package bookServiceFactory;

import service.BookServiceImpl;
import service.IBookService;

public class BookServiceFactory {

	private BookServiceFactory() {

	}

	private static IBookService ibs = null;

	public static IBookService getBookService() {

		if (ibs == null) {
			ibs = new BookServiceImpl();
		}
		return ibs;

	}

}
