package Q1.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

import Q1.UserPojo.UserPojo;

public class DBManager {
	Connection connect;
	public Connection establishConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcURL = "jdbc:mysql://localhost:3306/user_db";
		String user = "root";
		String password = "root";
		connect = DriverManager.getConnection(jdbcURL, user, password);
		return connect;
	} //end of establishConnection();
	public void closeConnection() {
		try {
			System.out.println("Connection Closed");
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean addChild(UserPojo user) {
		try {
			connect = establishConnection();
			PreparedStatement statement = connect.prepareStatement("INSERT INTO KID_TABLE (FIRSTNAME, LASTNAME, AGE) VALUES (?,?,?)");
			System.out.println("FirstName : "+user.getFirstName());
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setInt(3, user.getAge());
			statement.executeUpdate();
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //end of try-catch
		return false;
	} //end of addChild method
	
	
	public boolean addAdult(UserPojo user) {
		try {
			connect = establishConnection();
			PreparedStatement statement = connect.prepareStatement("INSERT INTO ADULT_TABLE (FIRSTNAME, LASTNAME, AGE) VALUES (?,?,?)");
			System.out.println("FirstName : "+user.getFirstName());
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setInt(3, user.getAge());
			statement.executeUpdate();
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //end of try-catch
		return false;
	} //end of addAdult method
} //end of DBManager Class
