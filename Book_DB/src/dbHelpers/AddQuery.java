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
public class AddQuery {
	public Connection connection;
	public AddQuery(String dbName, String uname, String pwd){
		//String url = "jdbc:mysql://54.169.158.3:3306/" +dbName;
		try {
			
			//this.connection = DriverManager.getConnection(url, uname, pwd);
			this.connection=DriverManager.getConnection("jdbc:mysql://54.169.158.3:3306/scif_library?user=root&password=2xliulriI&useUnicode=true&characterEncoding=utf-8");
		} catch (SQLException e1) {
			
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


	public void doAdd(Book book) {
		
		String query = "insert into books (title, author, pages) values (?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setInt(3,book.getPages());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
	}
}
