package dbHelpers;

import java.sql.*;

public class DeleteQuery {
	private Connection connection;
	public DeleteQuery(String dbName, String uname, String pwd) {
		String url = "jdbc:mysql://54.169.158.3:3306/" +dbName;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void doDelete(int bookID) {
		//set up a String to hold out query
		String query = "delete from books where bookID=?";
		//create a preparedstatement using our query string
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			//fill in the preparedstatement
			ps.setInt(1, bookID);
			//execute the query
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
