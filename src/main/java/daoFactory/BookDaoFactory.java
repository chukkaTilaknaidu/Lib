package daoFactory;

import persistence.BookDaompl;
import persistence.IBookDao;

public class BookDaoFactory {
	private BookDaoFactory() {

	}

	private static IBookDao ibd = null;

	public static IBookDao getBookDao() {
		if (ibd == null) {
			ibd = new BookDaompl();
		}
		return ibd;

	}

}
