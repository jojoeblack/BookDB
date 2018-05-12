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
public class UpdateQuery {
	private Connection connection;
	public UpdateQuery(String dbName, String uname, String pwd) {
		//String url = "jdbc:mysql://54.169.158.3:3306/" +dbName;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//this.connection=DriverManager.getConnection(url, uname, pwd);
			this.connection=DriverManager.getConnection("jdbc:mysql://54.169.158.3:3306/scif_library?user=root&password=2xliulriI&useUnicode=true&characterEncoding=utf-8");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doUpdate(Book book) {
		String query = "update books set title=?, author=?, pages=? where bookID=?";
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setInt(3, book.getPages());
			ps.setInt(4, book.getBookID());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
