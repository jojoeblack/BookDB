/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Book;

/**
 * @author Win10
 *
 */
public class ReadQuery {
	
	private Connection connection;
	private ResultSet results;
	
	public ReadQuery(String dbName, String uname, String pwd) {
		String url = "jdbc:mysql://54.169.158.3:3306/" +dbName;
		//set up driver
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
            this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	public void doRead() {
		
		String query = "select * from books";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getHTMLTable() {
		String table="";
		table += "<table border = 1 align='center'>";
		table += "<tr>";
		table += "<th>";
		   table += "書名";
		table += "</th>";
		table += "<th>";
		   table += "作者";
		table += "</th>";
		table += "<th>";
		   table += "頁數";
		table += "</th>";
		table += "<th>";
		   table += "更新/移除";
		table += "</th>";
		table += "</tr>";
		try {
			while(this.results.next()) {
				Book book = new Book(); 
				book.setBookID(this.results.getInt("bookID"));
				book.setTitle(this.results.getString("title"));
				book.setAuthor(this.results.getString("author"));
				book.setPages(this.results.getInt("pages"));
				
				
				table += "<tr>";
				table += "<td>";
				 	table += book.getTitle();
				table += "</td>";
				table += "<td>";
				 	table += book.getAuthor();
				table += "</td>";
				table += "<td>";
				 	table += book.getPages();
				table += "</td>";
				table += "<td>";
				    table += "<a href=update?bookID=" + book.getBookID() + ">update</a> <a href=delete?bookID=" + book.getBookID() + ">delete</a>";
				table += "</td>";
				table += "</tr>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table += "</table>";
		return table;
	}
}
