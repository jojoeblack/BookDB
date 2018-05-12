/**
 * 
 */
package dbHelpers;

import java.sql.*;

import model.Book;

/**
 * @author Win10
 *
 */
public class ReadRecord {
	private Connection connetion ;
	private ResultSet results;
	
	private Book book =  new Book();
    private int bookID;
	
	public ReadRecord(String dbName, String uname, String pwd, int bookID) {
		
		String url = "jdbc:mysql://54.169.158.3:3306/" +dbName;
		this.bookID = bookID;//passed in by 
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connetion = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public void doRead() {
		String query = "select * from books where bookID = ? ";
		try {
			PreparedStatement ps = connetion.prepareStatement(query);
			
			ps.setInt(1, this.bookID);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			book.setBookID(this.results.getInt(1));
			book.setTitle(this.results.getString(2));
			book.setAuthor(this.results.getString(3));
			book.setPages(this.results.getInt(4));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Book getBook() {
		return this.book;
	}
	
	
	 
} 

