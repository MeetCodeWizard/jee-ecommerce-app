package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// getting values from jsp
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomapp", "root", "Meet@1608");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(conn);
		
		if(conn != null) {
			try {
				PreparedStatement pstmt = conn.prepareStatement("insert into users(firstname, email, gender, password, role) values(?,?,?,?,?)");
				pstmt.setString(1, firstName);
				pstmt.setString(2, email);
				pstmt.setString(3, gender);
				pstmt.setString(4, password);
				pstmt.setString(5, "CUSTOMER");
				
				int res = pstmt.executeUpdate();
				System.out.println(res + " records inserted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Connection not established");
		}
	}
}
