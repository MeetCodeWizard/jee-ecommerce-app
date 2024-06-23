package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;
import com.util.DbConnection;

@WebServlet("/ListUserServlet")
public class ListUserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = DbConnection.getConnection();
		
		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from users");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String firstName = rs.getString("firstname");
				String email = rs.getString("email");
				
				System.out.println(id + " " + firstName + " " + email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
