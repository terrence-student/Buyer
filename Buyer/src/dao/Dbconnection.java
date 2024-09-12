package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

	public static void main(String[] args) {
		System.out.println(Dbconnection.getDb());

	}
	
	public static Connection getDb()
	{
		Connection cn=null;
		
		String URL="jdbc:mysql://localhost:3306/buyer";
		String username="root";
		String password="1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(URL,username,password);
			
		
		
		
		
		
		
		} catch (ClassNotFoundException e) {
			System.out.println("no Driver");
			e.printStackTrace();
		}
		
		
		catch (SQLException e) {
		System.out.println("no Connection");
		e.printStackTrace();
		}
		
		return cn;
	
	}

}
