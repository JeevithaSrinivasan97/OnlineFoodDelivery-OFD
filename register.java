package allserv;
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


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calldatabase.GetData;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
/**
 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
 */
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		PrintWriter out=response.getWriter();
		int cid=(int)(Math.random()*10000);
		String cname=request.getParameter("cname");
		String cmail=request.getParameter("cmail");
		String cpass=request.getParameter("cpass");
		String cadd=request.getParameter("cadd");
		String city=request.getParameter("city");
		String zip=request.getParameter("zip");
		String cphn=request.getParameter("cphn");

		
		Connection cn=GetData.getCn();
		PreparedStatement ps=cn.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?)");
		ps.setInt(1, cid);
		ps.setString(2, cname);
		ps.setString(3, cmail);
		ps.setString(4, cpass);
		ps.setString(5, cadd);
		ps.setString(6, city);
		ps.setString(7, zip);
		ps.setString(8, cphn);
		ps.execute();
		out.print("Registration success for ID :"+cid);
		RequestDispatcher rd=request.getRequestDispatcher("Register.html");
		rd.include(request, response);
		
	}catch(Exception e) {
		System.out.println(e);
	}
}

}
