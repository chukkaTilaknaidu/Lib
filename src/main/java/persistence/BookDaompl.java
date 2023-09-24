package persistence;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jdbcfiles.Jdbc;
import dto.Dto;

public class BookDaompl implements IBookDao {

	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	@Override
	public String addBook(Dto book) {
		try {
			con = Jdbc.getJdbcConnection();
			String sql = "insert into college_library.books(`title`,`author`,`category`,`ISBN`,`available_copies`) values(?,?,?,?,?)";
			if (con != null) {
				pstm = con.prepareStatement(sql);
			}
			if (pstm != null) {
				pstm.setString(1, book.getTitle());
				pstm.setString(2, book.getAuthor());
				pstm.setString(3, book.getCategory());
				pstm.setInt(4, book.getISBN());
				pstm.setInt(5, book.getNo_Of_Copies());

				int row_changed = pstm.executeUpdate();

				if (row_changed == 1) {
					return "sucess";
				}

			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();

		}
		return "failure";

	}

	@Override
	public String deleteBook(Dto book) {
		try {
			con = Jdbc.getJdbcConnection();
			if (con != null) {
				String sql = "delete from books where isbn=? ";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, book.getISBN());

			}
			if (pstm != null) {
				int row_changed = pstm.executeUpdate();
				if (row_changed == 1) {
					return "sucess";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return "failure";
	}

	@Override
	public Dto searchBook(String title) {
		try {
			con = Jdbc.getJdbcConnection();
			if (con != null) {
				String sql = "SELECT title, author, category, isbn, available_copies FROM books WHERE title LIKE ? OR author LIKE ? OR category LIKE ?";
				pstm = con.prepareStatement(sql);
				String searchQuery = "%" + title + "%"; // Add wildcard to allow partial matching
				pstm.setString(1, searchQuery);
				pstm.setString(2, searchQuery);
				pstm.setString(3, searchQuery);

			}
			if (pstm != null) {
				rs = pstm.executeQuery();

				while (rs.next()) {
					// Populate the Dto object with the book details
					Dto resultDto = new Dto();
					resultDto.setTitle(rs.getString(1));
					resultDto.setAuthor(rs.getString(2));
					resultDto.setCategory(rs.getString(3));
					resultDto.setISBN(rs.getInt(4));
					resultDto.setNo_Of_Copies(rs.getInt(5));

					return resultDto;
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			// Close resources (con, pstm, rs) here if needed
		}

		return null;
	}

	@Override
	public String addStudent(Dto book) {
		Dto dto = new Dto();
		try {
			con = Jdbc.getJdbcConnection();
			String sql = "insert into college_library.Student_data (`StudentName`,`StudentRegisterNumber`,`EMAIL_ID`,`SETPASSWORD`,`PhoneNumber`) values(?,?,?,?,?)";

			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, book.getStudentName());
				pstm.setInt(2, book.getStudentRegistrationNumber());
				pstm.setString(3, book.getEmail());
				pstm.setString(4, book.getPassword());
				pstm.setLong(5, book.getPhone_Number());

			}
			if (pstm != null) {
				int rw = pstm.executeUpdate();
				if (rw == 1) {
					return "sucess";
				}
			}

		} catch (SQLException | IOException ioe) {
			ioe.printStackTrace();

		}

		return "failure";
	}

	@Override
	public String addLibrarian(Dto book) {
		Dto dto = new Dto();
		try {
			con = Jdbc.getJdbcConnection();
			String sql = "insert into college_library.librarianregistration (`Librarian_name`,`Librarian_register_number`,`Librararian_emaill`,`Password`,`Phone_number`) values(?,?,?,?,?)";

			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, book.getLibrarian_Name());
				pstm.setInt(2, book.getLibrarian_Register_Number());
				pstm.setString(3, book.getLibrararian_Emaill());
				pstm.setString(4, book.getPassword_Librarian());
				pstm.setLong(5, book.getPhone_Number());

			}
			if (pstm != null) {
				int rw = pstm.executeUpdate();
				if (rw == 1) {
					return "sucess";
				}
			}

		} catch (SQLException | IOException ioe) {
			ioe.printStackTrace();

		}

		return "failure";
	}

	@Override
	public Dto student_Login(int RegisterNumber) {
		try {
			con = Jdbc.getJdbcConnection();
			if (con != null) {
				String sql = "SELECT  StudentRegisterNumber,SETPASSWORD from student_data where StudentRegisterNumber=? ";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, RegisterNumber);

			}
			if (pstm != null) {
				rs = pstm.executeQuery();

				while (rs.next()) {
					// Populate the Dto object with the book details
					Dto resultDto = new Dto();
					resultDto.setStudent_register_number(rs.getInt(1));
					resultDto.setStudent_password_login(rs.getString(2));

					return resultDto;
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			// Close resources (con, pstm, rs) here if needed
		}

		return null;
	}

	@Override
	public Dto librarian_Login(int password) {

		try {
			con = Jdbc.getJdbcConnection();
			if (con != null) {
				String sql = "SELECT  Librarian_register_number ,Password from librarianregistration where Password=? ";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, password);

			}
			if (pstm != null) {
				rs = pstm.executeQuery();

				while (rs.next()) {
					// Populate the Dto object with the book details
					Dto resultDto = new Dto();
					resultDto.setLibrarian_register_login(rs.getInt(1));

					resultDto.setLibrarian_password_login(rs.getInt(2));

					return resultDto;
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			// Close resources (con, pstm, rs) here if needed
		}

		return null;
	}

	@Override
	public Dto bookBorrow(long isbn) {
		try {
			con = Jdbc.getJdbcConnection();
			String sql = "select isbn from college_library.books where isbn=?";

			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setLong(1, isbn);
			}
			if (pstm != null) {
				rs = pstm.executeQuery();
				while (rs.next()) {
					Dto dto = new Dto();
					dto.setStudent_Isbn(rs.getLong(1));
					return dto;
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String request(Dto requests) {
		try {
			con = Jdbc.getJdbcConnection();
			if (con != null) {
				// Check if the REGISTER_NUMBER exists in STUDENT_borrowings_list
				String checkSql = "SELECT COUNT(*) FROM college_library.STUDENT_borrowings_list WHERE REGISTER_NUMBER=?";
				pstm = con.prepareStatement(checkSql);
				pstm.setInt(1, requests.getRequest_RegisterNumber());
				rs = pstm.executeQuery();

				if (rs.next() && rs.getInt(1) > 0) {
					// The REGISTER_NUMBER already exists in STUDENT_borrowings_list, so don't
					// insert into request
					return "already_exists";
				} else {
					// The REGISTER_NUMBER doesn't exist in STUDENT_borrowings_list, insert into
					// request
					String insertSql = "INSERT INTO college_library.request (`REGISTER_NUMBER`, `BOOK_ISBN`) VALUES (?, ?)";
					pstm = con.prepareStatement(insertSql);
					pstm.setInt(1, requests.getRequest_RegisterNumber());
					pstm.setLong(2, requests.getRequest_Book_ISBN());
					int rw = pstm.executeUpdate();

					if (rw == 1) {
						return "sucess";
					}
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			// Close resources (con, pstm, rs) here if needed
		}

		return "failure";
	}

	@Override
	public Dto request_return() {
		try {
			con = Jdbc.getJdbcConnection();
			String sql = "select * from college_library.request";
			Dto dto = new Dto();
			if (con != null) {
				pstm = con.prepareStatement(sql);
			}
			if (pstm != null) {
				rs = pstm.executeQuery();
			}
			while (rs.next()) {
				dto.setReturn_Request_RegisterNumber(rs.getInt(1));
				dto.setReturn_Request_BookISBN(rs.getLong(2));
				return dto;
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String delete_Request(Dto dto) {
		try {
			con = Jdbc.getJdbcConnection();
			String deleteSql = "DELETE FROM college_library.request WHERE REGISTER_NUMBER=?";
			String insertSql = "INSERT INTO college_library.STUDENT_borrowings_list (`REGISTER_NUMBER`, `BOOK_ISBN`, `BORROWING_DATE`) VALUES (?, ?, CURRENT_DATE())";
			String sql_status = "insert into college_library.status (`registerNumber`,`status`,`isbn`) values (?,?,?)";
			if (con != null) {
				// First, delete the request
				pstm = con.prepareStatement(deleteSql);
				pstm.setInt(1, dto.getDelete_registerNumber());
				int deleteResult = pstm.executeUpdate();

				if (deleteResult > 0) {
					// If the request is deleted successfully, insert the data into
					// BORROWINGS_STUDENT_LIST
					pstm = con.prepareStatement(insertSql);
					pstm.setInt(1, dto.getDelete_registerNumber()); // Use the REGISTER_NUMBER from the deleted request
					pstm.setLong(2, dto.getDelete_isbn());
					int insertResult = pstm.executeUpdate();

					if (insertResult > 0) {
						pstm = con.prepareStatement(sql_status);
						pstm.setInt(1, dto.getDelete_registerNumber());
						pstm.setString(2, "yes");
						pstm.setLong(3, dto.getDelete_isbn());
						int insertion = pstm.executeUpdate();

						if (insertion > 0) {
							return "success";
						}
					}
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			// Close resources (con, pstm) here if needed
		}

		return "failure";
	}

	@Override
	public String return_Book(Dto dto) {
	    try {
	        con = Jdbc.getJdbcConnection();
	        if (con != null) {
	            String sql_checking = "select REGISTER_NUMBER, BOOK_ISBN from college_library.student_BORROWINGS_list where REGISTER_NUMBER=?";
	            String sql_ = "delete from college_library.status where registerNumber=?";
	            String sql = "insert into college_library.return_books (`register_Number`, `book_isbn`, `return_Date`) values (?, ?, CURRENT_DATE())";

	            pstm = con.prepareStatement(sql_checking);
	            pstm.setInt(1, dto.getReturn_registerNumber());
	            rs = pstm.executeQuery();

	            if (rs.next()) {
	                int rgNUM = rs.getInt(1);
	                long isbn = rs.getLong(2);

	                if (rgNUM == dto.getReturn_registerNumber() && isbn == dto.getReturn_book_ISBN()) {
	                    pstm = con.prepareStatement(sql_);
	                    pstm.setInt(1, dto.getReturn_registerNumber());
	                    int ra = pstm.executeUpdate();

	                    if (ra >= 1) {
	                        pstm = con.prepareStatement(sql);
	                        pstm.setInt(1, dto.getReturn_registerNumber());
	                        pstm.setLong(2, dto.getReturn_book_ISBN());
	                        int rc = pstm.executeUpdate();

	                        if (rc >= 1) {
	                            return "sucess";
	                        }
	                    }
	                }
	            }
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources (con, pstm, rs) here if needed
	    }
	    return null;
	}


	@Override
	public Dto fineCalculation(Dto dto) {
		try {
			Dto resultDto = new Dto();
			LocalDate return_date = null;
			LocalDate borrowing_date = null;
			String sql_fine = "select return_Date from return_Books where register_Number=?";
			String sql_last = "select BORROWING_DATE from student_BORROWINGS_list where Register_NUmber=?";
			String sql_clear_return = "delete from return_Books where register_Number=?";
			String sql_clear_Borrow = "delete from student_BORROWINGS_list where register_Number=?";
			con = Jdbc.getJdbcConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql_fine);
				pstm.setInt(1, dto.getFine_Register_Number());
			}
			if (pstm != null) {
				rs = pstm.executeQuery();
				if (rs.next()) {
					return_date = rs.getDate(1).toLocalDate();
				}
			}
			if (con != null) {
				pstm = con.prepareStatement(sql_last);
				pstm.setInt(1, dto.getFine_Register_Number());
			}
			if (pstm != null) {
				rs = pstm.executeQuery();
			}
			while (rs.next()) {
				borrowing_date = rs.getDate(1).toLocalDate();
			}
			if (return_date != null && borrowing_date != null) {
				long daysBetween = ChronoUnit.DAYS.between(borrowing_date, return_date);

				resultDto.setDate(daysBetween);

			}
			if (con != null) {
				pstm = con.prepareStatement(sql_clear_Borrow);
				pstm.setInt(1, dto.getFine_Register_Number());

			}
			if (pstm != null) {
				int rc = pstm.executeUpdate();
				if (rc == 1) {
					if (con != null) {
						pstm = con.prepareStatement(sql_clear_return);
						pstm.setInt(1, dto.getFine_Register_Number());
					}
					if (pstm != null) {
						int rw = pstm.executeUpdate();
						return resultDto;

					}
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String status() {
		try {
			String sql = "select isbn from college_library.status";
			con = Jdbc.getJdbcConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
			}
			if (pstm != null) {
				rs = pstm.executeQuery();
				if (rs.next()) {
					return "sucess";
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
