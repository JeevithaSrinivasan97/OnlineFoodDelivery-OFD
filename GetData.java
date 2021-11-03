package calldatabase;
import java.sql.*;
import calldatabase.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.Connection;
import java.sql.DriverManager;
public class GetData {
	static Connection cn=null;
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/project";
	static String user="root";
	static String pass="jeevitha";
	
	public static Connection getCn()throws Exception{
		Class.forName(driver);
		cn=DriverManager.getConnection(url,user,pass);
		return cn;
	}
}

